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
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.DALException;



@WebServlet("/ServletListeEnchere")
public class ServletListeEnchere extends HttpServlet {
	
	private IArticleVenduManager articleVenduManager =  SingletonArticleVenduManager.getInstance();	
	private static final long serialVersionUID = 1L;
       
    public ServletListeEnchere() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	List<ArticleVendu> listeArticle = new ArrayList<>();
		
		try {
			
			listeArticle = null;
			listeArticle = articleVenduManager.selectAll();
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArticleVenduManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("listeArticle", listeArticle);
			
		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("/AccueilListeEncheres.jsp");
		rd.forward(request, response);
		
    }
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}