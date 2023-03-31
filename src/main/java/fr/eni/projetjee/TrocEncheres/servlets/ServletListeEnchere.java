package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;

/**
 * Servlet implementation class ListeEnchereServlet
 */
@WebServlet("/ServletListeEnchere")
public class ServletListeEnchere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeEnchere() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListeArticles.jsp");
		dispatcher.forward(request, response);
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		HttpSession session = request.getSession(true);

		List<ArticleVendu> listeArticles = new ArrayList();
		Connection con = null;


		String nomArticle = "";
		String articleCategory = "";

		
		nomArticle = request.getParameter("nom_article");
		articleCategory = request.getParameter("categories_article");
		String sqlquery = "SELECT * FROM article WHERE nom_article LIKE '%" + nomArticle +  "%' and categorie =  " + articleCategory;
		if (nomArticle != null && !(nomArticle.equals(""))) {
			sqlquery += " and isbn_code='" + nomArticle + "'";
		}
		if (articleCategory != null && !(articleCategory.equals("-1"))) {
			sqlquery += " dans la categorie='" + articleCategory + "'";
		}

		request.setAttribute("listeArticles", listeArticles);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/rechArticle.jsp");
		dispatcher.forward(request, response);
	}


}
