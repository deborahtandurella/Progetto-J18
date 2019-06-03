package magazinestore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.event.spi.ClearEvent;
import org.omg.CORBA.Request;
import org.w3c.dom.ls.LSInput;

import magazinestore.dao.CustomerDAO;
import magazinestore.entity.Cliente;

public class CustomerServices {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO = new CustomerDAO();
	}

	public void listCustomers(String message) throws ServletException, IOException {
		List<Cliente> listCustomer = customerDAO.listAll();
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		request.setAttribute("listCustomer", listCustomer);
		String listPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher =  request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCustomers() throws ServletException, IOException {
		listCustomers(null);
	}
	public void  createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Cliente existCustomer = customerDAO.findByEmail(email);
		
		if (existCustomer != null) {
			String message = "Non è possibile creare nuovo utente: l'email " 
					+ email + " esiste già";
			listCustomers(message);
		} else {
			String fullname = request.getParameter("fullname");
			String password = request.getParameter("password");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String zipcode = request.getParameter("zipcode");
			String country = request.getParameter("country");
			
			Cliente newCustomer = new Cliente();
			newCustomer.setEmail(email);
			newCustomer.setFullname(fullname);
			newCustomer.setPassword(password);
			newCustomer.setPhone(phone);
			newCustomer.setAddress(address);
			newCustomer.setCity(city);
			newCustomer.setZipcode(zipcode);
			newCustomer.setCountry(country);
			
			customerDAO.create(newCustomer);
			
			String message = "Nuovo cliente è stato creato con successo";
			listCustomers(message);
			
		}
		
	}
}
