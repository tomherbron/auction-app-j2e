package fr.eni.projetjee.TrocEncheres.servlets;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		RequestDispatcher rd = request.getRequestDispatcher("./ProfilUtilisateur.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur current = (Utilisateur) session.getAttribute("utilisateur");
		
		String pseudo = request.getParameter("pseudo-utilisateur");
		String nom = request.getParameter("nom-utilisateur");
		String prenom = request.getParameter("prenom-utilisateur");
		String email = request.getParameter("email-utilisateur");
		String telephone = request.getParameter("telephone-utilisateur");
		String rue = request.getParameter("rue-utilisateur");
		String codePostal = request.getParameter("cpo-utilisateur");
		String ville = request.getParameter("ville-utilisateur");
		String motDePasseNouveau = request.getParameter("mdp-utilisateur");
		
		current.setPseudo(pseudo);
		current.setNom(nom);
		current.setPrenom(prenom);
		current.setEmail(email);
		current.setTelephone(telephone);
		current.setRue(rue);
		current.setCodePostal(codePostal);
		current.setVille(ville);
		current.setMotDePasse(motDePasseNouveau);

		try {
			
			utilisateurManager.updateUtilisateur(current);

		} catch (DALException e) {
			e.printStackTrace();
			request.setAttribute("erreur", "Probleme de base de donnée.");
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
			request.setAttribute("erreur", "Probleme de manager.");
		}		
		
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		request.setAttribute("telephone", telephone);
		request.setAttribute("rue", rue);
		request.setAttribute("cpo", codePostal);
		request.setAttribute("ville", ville);
		request.setAttribute("credit", current.getCredit());
		
		RequestDispatcher rd = request.getRequestDispatcher("./ProfilUtilisateur.jsp");
		rd.forward(request, response);
		
	}

}
