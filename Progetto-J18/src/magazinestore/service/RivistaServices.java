package magazinestore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale.Category;

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

	private RivistaDAO rivistaDAO;
	private CategoryDAO categoryDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public RivistaServices( HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		rivistaDAO= new RivistaDAO();
		categoryDAO = new CategoryDAO();

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


		String title = request.getParameter("title");


		Rivista existRivista = rivistaDAO.findByTitle(title);
		if (existRivista != null) {
			String message = "Non Ë possibile creare un nuova rivista perchË il titolo '" 
					+ title + "' esiste giÔøΩ.";
			listRiviste(message);
			return;
		}
		Rivista newRivista= new Rivista();
		readRivistaFields(newRivista);

		Rivista createdRivista = rivistaDAO.create(newRivista);


		if (createdRivista.getRivistaId() > 0) {
			String message = "Un nuovo libro Ë stato creato con successo";
			request.setAttribute("message", message);
			listRiviste();

		}

	}
	public void readRivistaFields(Rivista rivista) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		float price = Float.parseFloat(request.getParameter("price"));

		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date publishDate = null;

		try {
			publishDate = dateFormat.parse(request.getParameter("publishDate"));
		} catch (ParseException e) {
			e.printStackTrace();
			throw new ServletException("Errore nel formato della data(Deve essere MM/dd/yyyy)");
		}




		rivista.setTitle(title);
		rivista.setDescription(description);
		rivista.setPrice(price);
		rivista.setPublishDate(publishDate);

		Integer categoryId = Integer.parseInt(request.getParameter("category"));
		Categoria category = categoryDAO.get(categoryId);
		rivista.setCategoria(category);

		Part part = request.getPart("RivistaImage");
		if (part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int) size];

			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();

			rivista.setImmagine(imageBytes);
		}

	}
	public void editRivista() throws ServletException, IOException {
		Integer rivistaId= Integer.parseInt(request.getParameter("id"));
		Rivista rivista=rivistaDAO.get(rivistaId);
		List<Categoria> listCategory=categoryDAO.listAll();

		request.setAttribute("rivista",rivista);
		request.setAttribute("listCategory",listCategory);

		String editPage= "rivista_form.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);

	}

	public void updateRivista() throws ServletException, IOException {
		Integer rivistaId= Integer.parseInt(request.getParameter("rivistaId"));
		String title = request.getParameter("title");


		Rivista existRivista = rivistaDAO.get(rivistaId);
		Rivista rivistaByTitle =rivistaDAO.findByTitle(title);

		if(rivistaByTitle!=null &&!existRivista.equals(rivistaByTitle)) {
			String message="non Ë possibile cambiare a questo titolo perch√® gi√† usato da un altra rivista.";
			listRiviste(message);
			return;
		}
		readRivistaFields(existRivista);
		rivistaDAO.update(existRivista);
		String message= "La rivista √® stata aggiornata con successo.";
		listRiviste(message);

	}

	public void deleteRivista() throws ServletException, IOException {
		Integer rivistaId= Integer.parseInt(request.getParameter("id"));
		rivistaDAO.delete(rivistaId);

		String message= "La rivista e' stata eliminata.";
		listRiviste(message);

	}

	public void listRivistaByCatagory() throws ServletException, IOException {
		int categoryId =Integer.parseInt(request.getParameter("id"));
		List<Rivista> listRiviste =rivistaDAO.listByCategory(categoryId);
		Categoria category= categoryDAO.get(categoryId);

		request.setAttribute("listRiviste",listRiviste);
		request.setAttribute("category",category);


		String listPage= "frontend/riviste_list_by_category.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);

	}

	public void viewRivistaDetail() throws ServletException, IOException {
		Integer rivistaId= Integer.parseInt(request.getParameter("id"));
		Rivista rivista= rivistaDAO.get(rivistaId);

		request.setAttribute("rivista",rivista);

		String detailPage= "frontend/rivista_detail.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(detailPage);
		requestDispatcher.forward(request, response);

	}

	public void search() throws ServletException, IOException{
		String keyword= request.getParameter("keyword");
		List<Rivista> result = null;
		if(keyword.equals("")) {
			result= rivistaDAO.listAll();
		}else {
			result=rivistaDAO.search(keyword);
		}
		request.setAttribute("keyword",keyword);
		request.setAttribute("result",result);
		
		String resultPage= "frontend/search_result.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(resultPage);
		requestDispatcher.forward(request, response);


	}
}
