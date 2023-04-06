package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.IEnchereManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonEnchereManager;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Enchere;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {

	IArticleVenduManager articleManager = SingletonArticleVenduManager.getInstance();
	IEnchereManager enchereManager = SingletonEnchereManager.getInstance();
	
	private static final long serialVersionUID = 1L;

	public ServletDetailVente() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		Integer id = Integer.parseInt(request.getParameter("id"));

		ArticleVendu article = null;

		try {

			article = articleManager.selectById(id);

		
		} catch (ArticleVenduManagerException e) {
			e.printStackTrace();
		}
<<<<<<< HEAD
		
		List<Enchere> lstEncheres = null;
		
		try {
			
			lstEncheres = enchereManager.selectAllEncheres();
			System.out.println("lstEncheres : "+  lstEncheres);
			
		} catch (DALException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Integer enchMax = 0;
		Utilisateur winner = null;
		
		for (int i = 0; i < lstEncheres.size(); i++) {
			if (lstEncheres.get(i).getMontantEnchere() >= enchMax ) {
				enchMax = lstEncheres.get(i).getMontantEnchere();
				winner = lstEncheres.get(i).getUtilisateur();
			}
		}
		
		System.out.println(winner);
		
		request.setAttribute("acquereur", winner);
		
=======

>>>>>>> branch 'master' of https://github.com/tomyonearth/trocEncheres.git
		session.setAttribute("utilisateur", utilisateur);
		request.setAttribute("article", article);
		RequestDispatcher rd = request.getRequestDispatcher("./DetailVente.jsp");

		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");

		
		// Récupérer l'article et le montant de l'enchere, date, utilisateur

		String montantSaisi = request.getParameter("proposition");
		ArticleVendu articleAModifier = (ArticleVendu) session.getAttribute("article");
		
		Integer montantEnchere = Integer.parseInt(montantSaisi);
		
		Enchere enchere = null;
		
<<<<<<< HEAD
		try {
			
			 enchere = enchereManager.selectEnchereByNoArticle(articleAModifier.getNoArticle());
			 
		} catch (DALException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
=======
		// Set le prix de vente au montant saisir par l'utilisateur
>>>>>>> branch 'master' of https://github.com/tomyonearth/trocEncheres.git
		
		if (montantEnchere >= articleAModifier.getMiseAPrix()) {
			articleAModifier.setPrixDeVente(montantEnchere);
		} else {
			//Erreur
		}
		
<<<<<<< HEAD
		Utilisateur acquereur = enchere.getUtilisateur();
		System.out.println("L'acquéreur est : " + acquereur);
		
=======
		// Update l'article en BDD
>>>>>>> branch 'master' of https://github.com/tomyonearth/trocEncheres.git
		
		try {
			
			articleManager.updatePdv(articleAModifier);
			enchereManager.updateEnchere(enchere);
			
		} catch (ArticleVenduManagerException e) {
			e.printStackTrace();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("utilisateur", utilisateur);
		request.setAttribute("article", articleAModifier);
		request.setAttribute(montantSaisi, montantEnchere);
		RequestDispatcher rd = request.getRequestDispatcher("./DetailVente.jsp");
		rd.forward(request, response);

	}

}
