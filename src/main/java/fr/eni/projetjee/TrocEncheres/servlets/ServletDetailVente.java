package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

/**
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {
	
	IArticleVenduManager articleManager = SingletonArticleVenduManager.getInstance();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetailVente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		
		Integer idArticle = Integer.parseInt(request.getParameter("id"));
		System.out.println("Coucou" + idArticle);
		
		ArticleVendu article=null;
		
		
		try {
			
		article =	articleManager.selectById(idArticle);
		System.out.println(article);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleVenduManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("article", article);
		RequestDispatcher rd = request.getRequestDispatcher("./DetailVente.jsp");
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		String proposition = request.getParameter("proposition");
		Integer propo = Integer.parseInt(proposition);
		ArticleVendu article = (ArticleVendu) request.getAttribute("article");
		Integer nouveauPrix;
		
		if(propo > article.getPrixDeVente() ) {
			nouveauPrix=propo;
		} else {
			nouveauPrix = article.getPrixDeVente();
		}
			
		
		*/
		
		
		doGet(request, response);
	}

}
