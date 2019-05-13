package magazinestore.controller.admin.rivista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import magazinestore.controller.BaseServlet;
import magazinestore.service.RivistaServices;


@WebServlet("/admin/new_rivista")
public class NewRivistaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public NewRivistaServlet() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		 throws ServletException, IOException {
		RivistaServices rivistaServices = new RivistaServices(entityManager, request, response);
		rivistaServices.showRivistaNewForm();
	}

}
