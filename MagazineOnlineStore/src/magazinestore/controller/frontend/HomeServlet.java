package magazinestore.controller.frontend;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magazinestore.controller.BaseServlet;
import magazinestore.dao.CategoryDAO;
import magazinestore.entity.Categoria;

import java.io.IOException;
import java.util.List;

@WebServlet("") //vuota perchè sarà  la nostra home page principale
public class HomeServlet extends BaseServlet {
    public HomeServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	CategoryDAO categoryDAO = new CategoryDAO(entityManager);
    	List<Categoria> listCategory = categoryDAO.listAll();
    	request.setAttribute("listCategory", listCategory);
    	
    	/*Codice per puntare direttamente alla homepage*/
        String homepage = "frontend/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(homepage);
        dispatcher.forward(request,response);
        //--


    }
}
