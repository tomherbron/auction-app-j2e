package fr.eni.projetjee.TrocEncheres.servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.sql.Result;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.ICategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonCategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.UtilisateurManagerException;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.dal.DALException;



@WebServlet("/ServletListeEnchere")
public class ServletListeEnchere extends HttpServlet {
	
	private IArticleVenduManager articleVenduManager =  SingletonArticleVenduManager.getInstance();	
	private ICategorieManager categorieManager =  SingletonCategorieManager.getInstance();	
	private static final long serialVersionUID = 1L;
       
    public ServletListeEnchere() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<ArticleVendu> listeArticle = new ArrayList<>();
    	List<Categorie> listeCategorie = new ArrayList<>();
		
		try {
			
			listeArticle = null;
			listeArticle = articleVenduManager.selectAll();
			
			listeCategorie = null;
			listeCategorie = categorieManager.selectAll();
			
			
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleVenduManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String query = request.getParameter("query");
		
		String type = request.getParameter("categories");
		
		List<ArticleVendu> results = null;

		if ("toutes".equals(type)) {
			
		    try {
				results = articleVenduManager.selectAll();
			} catch (DALException | ArticleVenduManagerException e) {
				e.printStackTrace();
			}
		} else if ("email".equals(type)) {
		    try {
				results = articleVenduManager.selectByCategorie();
			} catch (DALException | ArticleVenduManagerException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("results", results);
		request.setAttribute("listeArticle", listeArticle);
		request.setAttribute("listeCategorie", listeCategorie);
				
		
		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("./AccueilListeEncheres.jsp");
		rd.forward(request, response);
		
		
		
		
		
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}