package magazinestore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
			listRiviste(null);
		}
	public void listRiviste(String message) throws ServletException, IOException {
		
	  List<Rivista> listRivista= rivistaDAO.listAll();
	  request.setAttribute("listRivista",listRivista);
	  
	  if (message != null) {
		request.setAttribute("message", message);
	  }
	  
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

	public void createRivista() throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Rivista existRivista = rivistaDAO.findByTitle(title);
		
		if (existRivista != null) {
			String message = "Non è possibile creare un nuova rivista perchè il titolo '" 
							+ title + "' esiste già.";
			listRiviste(message);
			return;
		}
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = null;
		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException("Errore nel formato della data(Deve essere MM/dd/yyyy)");
		}
		
		System.out.println("Categry ID: " + categoryId);
		System.out.println("title ID: " + title);
		System.out.println("Description ID: " + description);
		System.out.println("Price : " +price);
		System.out.println("publishDate ID: " + publishDate);
		
		Rivista newRivista = new Rivista();
		newRivista.setTitle(title);
		newRivista.setDescription(description);
		newRivista.setPrice(price);
		newRivista.setPublishDate(publishDate);
		
		Categoria category = categoryDAO.get(categoryId);
		newRivista.setCategoria(category);
		
		Part part = request.getPart("RivistaImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
			
			newRivista.setImmagine(imageBytes);
		}
		
		Rivista createdRivista = rivistaDAO.create(newRivista);
		
		if (createdRivista.getRivistaId() > 0) {
			String message = "Un nuovo libro è stato creato con successo";
			request.setAttribute("message", message);
			listRiviste();
			
		}

	}
}
