package magazinestore.service;

import static magazinestore.service.CommonUtitlity.forwardToPage;
import static magazinestore.service.CommonUtitlity.showMessageBackend;
import static magazinestore.service.CommonUtitlity.showMessageFrontend;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import magazinestore.controller.frontend.shoppingcart.ShoppingCart;
import magazinestore.dao.OrderDAO;
import magazinestore.entity.Rivista;
import magazinestore.entity.RivistaOrder;
import magazinestore.entity.Cliente;
import magazinestore.entity.DettagliOrdine;

public class OrderServices {
	private OrderDAO orderDao;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.orderDao = new OrderDAO();
	}

	public void listAllOrder() throws ServletException, IOException {
		listAllOrder(null);
	}
	
	public void listAllOrder(String message) throws ServletException, IOException {
		List<RivistaOrder> listOrder = orderDao.listAll();				
		request.setAttribute("listOrder", listOrder);
		forwardToPage("order_list.jsp", message, request, response);
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		RivistaOrder order = orderDao.get(orderId);
		
		if (order != null) {
			request.setAttribute("order", order);
			forwardToPage("order_detail.jsp", request, response);
		} else {
			String message = "Could not find order with ID " + orderId;
			showMessageBackend(message, request, response);
		}
	}

	public void showCheckoutForm() throws ServletException, IOException {
		forwardToPage("frontend/checkout.jsp", request, response);
	}

	public void placeOrder() throws ServletException, IOException {
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String paymentMethod = request.getParameter("paymentMethod");
		String subscriptionDuration = request.getParameter("subscriptionDuration");
		
		String shippingAddress = address + ", " + city + ", " + zipcode + ", " + country;
		
		RivistaOrder order = new RivistaOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress );
		order.setPaymentMethod(paymentMethod);
		//order.setSubscriptionDuration(subscriptionDuration);
		
		HttpSession session = request.getSession();
		Cliente customer = (Cliente) session.getAttribute("loggedCustomer");
		order.setCliente(customer);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
		Map<Rivista,Integer> items = shoppingCart.getItems();
		
		Iterator<Rivista> iterator = items.keySet().iterator();
		
		Set<DettagliOrdine> dettagliOrdines = new HashSet<>();
		
		while (iterator.hasNext()) {
			Rivista rivista = iterator.next();
			Integer quantity = items.get(rivista);
			 float subtotal = quantity * rivista.getPrice();
			
			DettagliOrdine orderDetail = new DettagliOrdine();
			orderDetail.setRivista(rivista);
			orderDetail.setRivistaOrder(order);
			//orderDetail.setQuantity(quantity);
			//orderDetail.setSubtotal(subtotal);
			
			order.setSubscriptionDuration(rivista.getDuration());
			
			dettagliOrdines.add(orderDetail);
		}
		
		order.setDettagliOrdines(dettagliOrdines);
		order.setTotal(shoppingCart.getTotalAmount());
		
		orderDao.create(order);
		
		shoppingCart.clear();
		
		String message = "Grazie, ordine effettuato con successo."
				+ "L'abbonamento è di tipo " + order.getSubscriptionDuration();
		showMessageFrontend(message, request, response);
	}

	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cliente customer = (Cliente) session.getAttribute("loggedCustomer");
		List<RivistaOrder> listOrders = orderDao.listByCustomer(customer.getClienteId());
		
		request.setAttribute("listOrders", listOrders);
		forwardToPage("frontend/order_list.jsp", request, response);
	}

	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int ordineId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Cliente customer = (Cliente) session.getAttribute("loggedCustomer");
		
		RivistaOrder order = orderDao.get(ordineId, customer.getClienteId());
		request.setAttribute("order", order);
		forwardToPage("frontend/order_detail.jsp", request, response);
	}

	public void showEditOrderForm() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));		

		
		
		HttpSession session = request.getSession();
		Object isPendingRivista = session.getAttribute("NewRivistaPendingToAddToOrder");
		
		if (isPendingRivista == null) {		
			RivistaOrder order = orderDao.get(orderId);
			session.setAttribute("order",order);
		} else {
			session.removeAttribute("NewRivistakPendingToAddToOrder");
		}
		String editPage="order_form.jsp";
		RequestDispatcher dispatcher= request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		RivistaOrder order = (RivistaOrder) session.getAttribute("order");
		
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String shippingAddress = request.getParameter("shippingAddress");
		String paymentMethod = request.getParameter("paymentMethod");
		String orderStatus = request.getParameter("orderStatus");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setShippingAddress(shippingAddress);
		order.setPaymentMethod(paymentMethod);
		order.setStatus(orderStatus);
		
		String[] arrayRivistaId = request.getParameterValues("rivistaId");
		String[] arrayPrice = request.getParameterValues("price");
		/*
		 * String[] arrayQuantity = new String[arrayRivistaId.length];
		 * 
		 * for (int i = 1; i <= arrayQuantity.length; i++) { arrayQuantity[i - 1] =
		 * request.getParameter("quantity" + i); }
		 */		
		Set<DettagliOrdine> orderDetails = order.getDettagliOrdines();
		orderDetails.clear();
		
		float totalAmount = 0.0f;
		
		for (int i = 0; i < arrayRivistaId.length; i++) {
			int rivistaId = Integer.parseInt(arrayRivistaId[i]);
     		float price = Float.parseFloat(arrayPrice[i]);
						
			DettagliOrdine orderDetail = new DettagliOrdine();
			orderDetail.setRivista(new Rivista(rivistaId));
			orderDetail.setRivistaOrder(order);
			
			orderDetails.add(orderDetail);
			
			totalAmount += price;
		}
		
		order.setTotal(totalAmount);
		
		orderDao.update(order);
		
		String message = "L'ordine " + order.getOrdineId() + " è stato modificato con successo";
		
		listAllOrder(message);
	}

	public void deleteOrder() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));
		
		RivistaOrder order = orderDao.get(orderId);
		
		if (order != null) {		
			orderDao.delete(orderId);
		
			String message = "The order ID " + orderId + " has been deleted.";
			listAllOrder(message);
		} else {
			String message = "Could not find order with ID " + orderId +
					", or it might have been deleted by another admin.";
			showMessageBackend(message, request, response);
		}
	}
}
