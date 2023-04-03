package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

/**
 * Servlet implementation class ServletAffichageProfilUtilisateurCourant
 */
@WebServlet("/ServletAffichageProfilUtilisateurCourant")
public class ServletAffichageProfilUtilisateurCourant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAffichageProfilUtilisateurCourant() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur current = (Utilisateur) session.getAttribute("utilisateur");
		
		String pseudo = current.getPseudo();
		String nom = current.getNom();
		String prenom = current.getPrenom();
		String email = current.getEmail();
		String telephone = current.getTelephone();
		String rue = current.getRue();
		String codePostal = current.getCodePostal();
		String ville = current.getVille();
		Integer credit = current.getCredit();
		
		request.setAttribute("pseudo", pseudo);
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		request.setAttribute("email", email);
		request.setAttribute("telephone", telephone);
		request.setAttribute("rue", rue);
		request.setAttribute("cpo", codePostal);
		request.setAttribute("ville", ville);
		request.setAttribute("credit", credit);
		
		RequestDispatcher rd = request.getRequestDispatcher("./ProfilUtilisateur.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
