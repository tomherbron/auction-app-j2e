package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;

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

@WebServlet("/ServletConnexionUtilisateur")
public class ServletConnexionUtilisateur extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();
	
    public ServletConnexionUtilisateur() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./LoginUtilisateur.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pseudo = request.getParameter("pseudo-utilisateur");
		String motDePasse = request.getParameter("mdp-utlisateur");
		
		HttpSession session = request.getSession();
		
		session.setAttribute(pseudo, session);
		session.setAttribute(motDePasse, session);
		
		try {
			
			Utilisateur utilisateur = utilisateurManager.selectByLogin(pseudo, motDePasse);
			
			if (utilisateur.getPseudo() == pseudo && utilisateur.getMotDePasse() == motDePasse) {
				RequestDispatcher rd = request.getRequestDispatcher("./AccueuilListeEncheres.jsp");
				rd.forward(request, response);
				doGet(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("./LoginUtilisateur.jsp");
			     rd.forward(request, response);
			     doGet(request, response);
			}
			
		} catch (DALException e) {
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
		}
		
	}

}
