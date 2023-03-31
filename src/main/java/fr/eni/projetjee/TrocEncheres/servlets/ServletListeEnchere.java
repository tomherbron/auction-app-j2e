package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.ArticleVenduDAOJdbcImpl;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;

/**
 * Servlet implementation class ListeEnchereServlet
 */

@WebServlet("/ServletListeEnchere")
public class ServletListeEnchere extends HttpServlet {
	
	private IArticleVenduManager articleVenduManager =  SingletonArticleVenduManager.getInstance();	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListeEnchere() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<ArticleVendu> listeArticles = new ArrayList<>();
		
		try {
			//recherche des Articles
			listeArticles = null;
			listeArticles = articleVenduManager.selectAll();
			request.setAttribute("listeArticles", listeArticles);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleVenduManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			// transfert affichage à la jsp
			RequestDispatcher rd = request.getRequestDispatcher("/ListeArticles.jsp");
			rd.forward(request, response);
		
			}
    	
    
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}