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

	private List<Categorie> listeCategorie;
	
    public ServletListeEnchere() {
        super();
        listeCategorie = null;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<ArticleVendu> listeArticle = null;
		
		try {
			
			listeArticle = articleVenduManager.selectAll();
			
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

		request.setAttribute("listeArticle", listeArticle);
		request.setAttribute("listeCategorie", listeCategorie);
		
		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("./AccueilListeEncheres.jsp");
		rd.forward(request, response);		
		
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	List<ArticleVendu> listeArticle = null;
    	
    	String query = request.getParameter("query");
		
		String type = request.getParameter("categories");
		
		System.out.println("type : " + type);
		
		List<ArticleVendu> results = null;

		if ("toutes".equals(type)) {
			
		    try {
		    	listeArticle = articleVenduManager.selectAll();
			} catch ( ArticleVenduManagerException e) {
				e.printStackTrace();
			}
		} else
			{
				try {

					listeArticle = articleVenduManager.selectByCategorie(type);
				} catch ( ArticleVenduManagerException e) {
					e.printStackTrace();
			}
		}

		request.setAttribute("listeArticle", listeArticle);
		request.setAttribute("listeCategorie", listeCategorie);
				
		
		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("./AccueilListeEncheres.jsp");
		rd.forward(request, response);
		
	}


}