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

/**
 * Servlet implementation class AffichageProfilUtilisateur
 */
@WebServlet("/ServletAffichageProfilUtilisateur")
public class ServletAffichageProfilUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();

    public ServletAffichageProfilUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utilisateur utilisateur=null;
		String pseudo = request.getParameter("pseudo");
		System.out.println("pseudo : " + pseudo);
		try {
			utilisateur = utilisateurManager.selectByPseudo(pseudo);
			System.out.println("utilisateur : " + utilisateur);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user", utilisateur);
		
		RequestDispatcher rd = request.getRequestDispatcher("./AffichageProfilUtilisateur.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
