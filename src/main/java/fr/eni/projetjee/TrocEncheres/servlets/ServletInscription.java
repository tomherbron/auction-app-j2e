package fr.eni.projetjee.TrocEncheres.servlets;

import java.io.IOException;
import java.sql.SQLException;

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


@WebServlet("/ServletInscription")
public class ServletInscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUtilisateurManager utilisateurManager = SingletonUtilisateurManager.getInstance();
       
    public ServletInscription() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String pseudo;
		 String nom;
		 String prenom;
		 String email;
		 String telephone;
		 String rue;
		 String codePostal;
		 String ville;
		 String motDePasse;
		 
		String confirmation; 
		Integer credit;
		Boolean administrateur;
		
		pseudo = request.getParameter("pseudo-utilisateur");
		nom = request.getParameter("nom-utilisateur");
		prenom = request.getParameter("prenom-utilisateur");
	    email = request.getParameter("email-utilisateur");
	    telephone =  request.getParameter("telephone-utilisateur");
	    rue =  request.getParameter("rue-utilisateur");
	    codePostal =  request.getParameter("cpo-utilisateur");
	    ville =  request.getParameter("ville-utilisateur");
	    motDePasse =  request.getParameter("mdp-utilisateur");
	    confirmation = request.getParameter("confirmation-mdp");
	    
	    credit = 0;
	    administrateur = false;
	    
	    Utilisateur newUser = new Utilisateur (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
	    
	    try {
	    	
	    	utilisateurManager.insertUtilisateur(newUser);
	    	
	    } catch (DALException e) {
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
		}
	    
	    RequestDispatcher rd = request.getRequestDispatcher("./loginutilisateur.jsp");
	     rd.forward(request, response);
	     doGet(request, response);
	     
	}
	
}
