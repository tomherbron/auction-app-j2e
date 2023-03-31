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

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/ServletConnexion")
public class ServletConnexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();

    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("./SeConnecter.jsp");
	     rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur utilisateur = null;
		
		String pseudo = request.getParameter("pseudo-utilisateur");
		String motDePasse = request.getParameter("mdp-utilisateur");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("utilisateur", utilisateur);
		
		try {
			
				List <Utilisateur> userList = new ArrayList<>();
				userList = utilisateurManager.selectAll();
				RequestDispatcher dispatcher = null;
				
				for (Utilisateur current : userList) {
					
					if (current.getPseudo().equals(pseudo) && current.getMotDePasse().equals(motDePasse)) {
						dispatcher = request.getRequestDispatcher("./AccueilListeEncheres.jsp");		
					} else if (!userList.contains(pseudo)) {
						dispatcher = request.getRequestDispatcher("./SeConnecter.jsp");
					}
				}
				
				dispatcher.forward(request, response);
				
		} catch (DALException e) {
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
		
		}
		
	}

}
