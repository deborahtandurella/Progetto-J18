package magazinestore.controller.admin.rivista;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import magazinestore.controller.BaseServlet;
import magazinestore.service.RivistaServices;

@WebServlet("/admin/create_rivista")
@MultipartConfig(
			fileSizeThreshold = 1024 * 10, //10 KB
			maxFileSize = 1024 * 300,	// 300 KB
			maxRequestSize = 1024 * 1024	// 1 MB
		)
public class CreateRivistaServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public CreateRivistaServlet() {
    	
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RivistaServices rivistaServices = new RivistaServices(entityManager, request, response);
		rivistaServices.createRivista();
	}

}
