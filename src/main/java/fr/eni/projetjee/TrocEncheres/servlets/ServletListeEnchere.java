package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.ICategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonCategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.UtilisateurManagerException;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

@WebServlet("/ServletListeEnchere")
public class ServletListeEnchere extends HttpServlet {

	private IArticleVenduManager articleVenduManager = SingletonArticleVenduManager.getInstance();
	private ICategorieManager categorieManager = SingletonCategorieManager.getInstance();
	private static final long serialVersionUID = 1L;

	private List<Categorie> listeCategorie;
	private List<Categorie> listeArticleFiltre;
	private List<ArticleVendu> listeArticleAVendre;

	public ServletListeEnchere() {
		super();
		listeCategorie = null;
		listeArticleAVendre = null;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

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

		session.setAttribute("utilisateur", utilisateur);
		request.setAttribute("listeArticle", listeArticle);
		request.setAttribute("listeCategorie", listeCategorie);

		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("./AccueilListeEncheres.jsp");
		rd.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		List<ArticleVendu> listeArticle = null;
		List<ArticleVendu> listeArticleFiltre = new ArrayList<>();

		
		String query = request.getParameter("query");
		String type = request.getParameter("categories");
		String radio = request.getParameter("radioAchatVente");
		String terminee = request.getParameter("terminee");
		String nonDebutee = request.getParameter("non_debutee");
		String enCours = request.getParameter("en_cours");
		String enchOuv = request.getParameter("ench_ouv");
		String mesEnch = request.getParameter("mes_encheres");
		String mesEnchRemp = request.getParameter("mes_ench_remp");
		
		if ("toutes".equals(type)) {

			try {
				listeArticle = articleVenduManager.selectAll();
			} catch (ArticleVenduManagerException e) {
				e.printStackTrace();
			}
		} else {
			try {

				listeArticle = articleVenduManager.selectByCategorie(type);
			} catch (ArticleVenduManagerException e) {
				e.printStackTrace();
			}
		}
		

		//boolean enchOuvBool = (radio.equals("achats") && enchOuv.equals("ench_ouv"));
		boolean enchOuvBool = (radio != null && enchOuv != null);

		//boolean mesEnchBool = (radio.equals("achats") && mesEnch.equals("mes_encheres"));
		boolean mesEnchBool = (radio != null && mesEnch != null);

		//boolean mesEnchRempBool = (radio.equals("achats") && mesEnchRemp.equals("mes_ench_remp"));
		boolean mesEnchRempBool = (radio != null && mesEnch != null);
		
		//boolean enCoursBool = (radio.equals("vente") && enCours.equals("en_cours"));
		boolean enCoursBool = (radio != null && enCours != null);
	//	boolean nonDebuteeBool = (radio.equals("vente") && nonDebutee.equals("non_debutee"));
		boolean nonDebuteeBool = (radio != null && nonDebutee != null);
//		boolean termineeBool = (radio.equals("vente") && terminee.equals("terminee"));		
		boolean termineeBool = (radio != null && terminee != null);		
					
		if (query != null) {

			for (ArticleVendu article : listeArticle) {
				boolean ajout = true;
				if (!(article.getNomArticle().contains(query) || 
						article.getDescription().contains(query))) {
					listeArticleFiltre.add(article);
					
				}
				
				if ((article.getEtatVente().equals(0)&&enchOuvBool)) { 
					listeArticleFiltre.add(article); 
				}
				if ((article.getUtilisateur().equals(utilisateur)&&mesEnchBool)) { 
					listeArticleFiltre.add(article);
				}
				if ((article.getEtatVente().equals(1)&&mesEnchRempBool)) { 
					listeArticleFiltre.add(article); 
				}
				
				
				
				if (!(article.getDateFinEnchere().isAfter(LocalDate.now())&&enCoursBool)) { 
					listeArticleFiltre.add(article); //ajouter condition pour filtrer les ventes de l'utilisateur
				}
				if (!(article.getDateDebutEnchere().isBefore(LocalDate.now())&&nonDebuteeBool)) { 
					listeArticleFiltre.add(article); //ajouter condition pour filtrer les ventes de l'utilisateur
				}
				if ((article.getEtatVente().equals(1)&&termineeBool)) { 
					listeArticleFiltre.add(article); //ajouter condition pour filtrer les ventes de l'utilisateur
				}
				
							
				
		}
			
	}
		
		request.setAttribute("listeArticle", listeArticleFiltre);
		request.setAttribute("listeCategorie", listeCategorie);
		request.setAttribute("listeTerminee", listeArticleAVendre);

		// transfert affichage à la jsp
		RequestDispatcher rd = request.getRequestDispatcher("./AccueilListeEncheres.jsp");
		rd.forward(request, response);
		
	}
}
