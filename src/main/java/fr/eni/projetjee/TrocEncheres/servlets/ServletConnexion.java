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
import javax.servlet.http.HttpSession;
import fr.eni.projetjee.TrocEncheres.bll.IUtilisateurManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonUtilisateurManager;
import fr.eni.projetjee.TrocEncheres.bll.UtilisateurManagerException;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();

	public ServletConnexion() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./SeConnecter.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo = request.getParameter("pseudo-utilisateur");
		String motDePasse = request.getParameter("mdp-utilisateur");

		Utilisateur utilisateur = null;

		try {

			utilisateur = utilisateurManager.selectByLogin(pseudo, motDePasse);

		} catch (DALException e1) {
			e1.printStackTrace();
		} catch (UtilisateurManagerException e1) {
			e1.printStackTrace();
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("utilisateur", utilisateur);

		try {

			List<Utilisateur> userList = new ArrayList<>();
			userList = utilisateurManager.selectAll();
			boolean userValid = false;

			for (Utilisateur current : userList) {
				if (current.getPseudo().equals(pseudo) && current.getMotDePasse().equals(motDePasse)) {
					userValid = true;
					break;
				}
			}

			if (userValid) {
				response.sendRedirect("ServletListeEnchere");
			} else {
				request.setAttribute("erreur", "Identifiant ou mot de passe incorrect");
				RequestDispatcher rd = request.getRequestDispatcher("./SeConnecter.jsp");
				rd.forward(request, response);
			}

		} catch (DALException e) {
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
		}
	
		
	}

}
