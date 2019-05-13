package magazinestore.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import magazinestore.dao.CategoryDAO;
import magazinestore.dao.RivistaDAO;
import magazinestore.entity.Categoria;
import magazinestore.entity.Rivista;

public class RivistaServices {
	   private EntityManager entityManager;
	    private RivistaDAO rivistaDAO;
	    private CategoryDAO categoryDAO;
	    private HttpServletRequest request;
	    private HttpServletResponse response;
	    
	 public RivistaServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
			super();
			this.entityManager = entityManager;
			this.request = request;
			this.response = response;
			rivistaDAO= new RivistaDAO(entityManager);
			categoryDAO = new CategoryDAO(entityManager);
			
		}

	public void listRiviste() throws ServletException, IOException {
		
	  List<Rivista> listRivista= rivistaDAO.listAll();
	  request.setAttribute("listRivista",listRivista);
	  String listpage= "rivista_list.jsp";
	  RequestDispatcher requestDispatcher=request.getRequestDispatcher(listpage);
	  requestDispatcher.forward(request, response);
	}
	public void showRivistaNewForm() throws ServletException, IOException {
		
		List<Categoria> listCategory= categoryDAO.listAll();
		  request.setAttribute("listCategory",listCategory);
		  String newPage= "rivista_form.jsp";
		  RequestDispatcher requestDispatcher=request.getRequestDispatcher(newPage);
		  requestDispatcher.forward(request, response);
	
	}
}
