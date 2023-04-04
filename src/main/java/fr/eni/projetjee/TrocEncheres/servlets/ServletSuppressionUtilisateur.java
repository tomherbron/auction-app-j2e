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

@WebServlet("/ServletSuppressionUtilisateur")
public class ServletSuppressionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();
       
    public ServletSuppressionUtilisateur() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Utilisateur current = (Utilisateur) session.getAttribute("utilisateur");
		
		Integer noUtilisateur = current.getNoUtilisateur();
		
		try {
			
			utilisateurManager.deleteUtilisateur(noUtilisateur);
			
		} catch (DALException | UtilisateurManagerException e) {
			e.printStackTrace();
		}
		
		session.invalidate();
		
		RequestDispatcher rd = request.getRequestDispatcher("/ServletConnexion");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
