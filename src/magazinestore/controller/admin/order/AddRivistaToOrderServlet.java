package magazinestore.controller.admin.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import magazinestore.dao.RivistaDAO;
import magazinestore.entity.Rivista;
import magazinestore.entity.RivistaOrder;
import magazinestore.entity.DettagliOrdine;

@WebServlet("/admin/add_rivista_to_order")
public class AddRivistaToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddRivistaToOrderServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rivistaId = Integer.parseInt(request.getParameter("rivistaId"));
		RivistaDAO rivistaDAO = new RivistaDAO();
		Rivista rivista = rivistaDAO.get(rivistaId);
		
		HttpSession session = request.getSession();
		RivistaOrder order = (RivistaOrder) session.getAttribute("order");
		
		float price = rivista.getPrice();
		
		DettagliOrdine	orderDetail = new DettagliOrdine();
		order.setTotal(price);
		
		order.getDettagliOrdines().add(orderDetail);
		
		request.setAttribute("rivista", rivista);
		session.setAttribute("NewRivistaPendingToAddToOrder", true);
		
		String resultPage = "add_rivista_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}

}
