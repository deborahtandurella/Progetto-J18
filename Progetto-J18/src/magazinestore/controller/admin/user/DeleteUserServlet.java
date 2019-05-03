package magazinestore.controller.admin.user;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magazinestore.controller.BaseServlet;
import magazinestore.service.UserServices;

@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

    public DeleteUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserServices userServices = new UserServices(entityManager,request, response);
			userServices.deleteUser();
	}


}
