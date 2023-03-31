package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.projetjee.TrocEncheres.bll.IUtilisateurManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonUtilisateurManager;
import fr.eni.projetjee.TrocEncheres.bll.UtilisateurManagerException;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

@WebServlet("/ServletGestionProfilUtilisateur")
public class ServletGestionProfilUtilisateur extends HttpServlet {
	
	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();
	
	private static final long serialVersionUID = 1L;
       
    public ServletGestionProfilUtilisateur() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./ModifierProfilUtilisateur.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo-utilisateur");
		String nom = request.getParameter("nom-utilisateur");
		String prenom = request.getParameter("prenom-utilisateur");
		String email = request.getParameter("email-utilisateur");
		String telephone = request.getParameter("telephone-utilisateur");
		String rue = request.getParameter("rue-utilisateur");
		String codePostal = request.getParameter("cpo-utilisateur");
		String ville = request.getParameter("ville-utilisateur");
		String motDePasseNouveau = request.getParameter("mdp-utilisateur");

		int credit = 100;
		boolean administrateur = false;

		Utilisateur newUser = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasseNouveau,
				credit, administrateur);

		try {
			
			utilisateurManager.updateUtilisateur(newUser);

		} catch (DALException e) {
			e.printStackTrace();
			request.setAttribute("erreur", "Probleme de base de donnée.");
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
			request.setAttribute("erreur", "Probleme de manager.");
		}
		
		

		RequestDispatcher rd = request.getRequestDispatcher("./ProfilUtilisateur.jsp");
		rd.forward(request, response);

		
		doGet(request, response);
	}

}
