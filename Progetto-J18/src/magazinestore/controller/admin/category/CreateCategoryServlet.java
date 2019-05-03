package magazinestore.controller.admin.category;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import magazinestore.controller.BaseServlet;
import magazinestore.service.CategoryServices;


@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends BaseServlet implements Servlet {
	private static final long serialVersionUID = 1L;

 
    public CreateCategoryServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.createCategory();
	}

}
