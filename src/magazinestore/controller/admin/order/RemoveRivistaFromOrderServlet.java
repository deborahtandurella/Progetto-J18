/*
 * package magazinestore.controller.admin.order;
 * 
 * import java.io.IOException; import java.util.Iterator; import java.util.Set;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import magazinestore.entity.RivistaOrder; import
 * magazinestore.entity.DettagliOrdine;
 * 
 * @WebServlet("/admin/remove_rivista_from_order") public class
 * RemoveRivistaFromOrderServlet extends HttpServlet { private static final long
 * serialVersionUID = 1L;
 * 
 * public RemoveRivistaFromOrderServlet() { super(); }
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { int rivistaId =
 * Integer.parseInt(request.getParameter("id")); HttpSession session =
 * request.getSession(); RivistaOrder order = (RivistaOrder)
 * session.getAttribute("order");
 * 
 * Set<DettagliOrdine> orderDetails = order.getDettagliOrdines();
 * Iterator<DettagliOrdine> iterator = orderDetails.iterator();
 * 
 * while (iterator.hasNext()) { DettagliOrdine orderDetail = iterator.next();
 * 
 * if (orderDetail.getRivista().getRivistaId() == rivistaId) {
 * 
 * float newTotal = order.getTotal() - orderDetail.getRivista().getPrice();
 * order.setTotal(newTotal);
 * 
 * iterator.remove(); } }
 * 
 * String editOrderFormPage = "order_form.jsp"; RequestDispatcher dispatcher =
 * request.getRequestDispatcher(editOrderFormPage); dispatcher.forward(request,
 * response); }
 * 
 * }
 */