package magazinestore.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import magazinestore.controller.BaseServlet;
import magazinestore.service.CategoryServices;

@WebServlet("/admin/edit_category")
public class EditCategoryServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public EditCategoryServlet() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.editCategoy();
	}

}
