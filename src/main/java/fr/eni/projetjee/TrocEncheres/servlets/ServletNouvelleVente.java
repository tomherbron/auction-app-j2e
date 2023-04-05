package fr.eni.projetjee.TrocEncheres.servlets;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bll.IArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.ICategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonArticleVenduManager;
import fr.eni.projetjee.TrocEncheres.bll.SingletonCategorieManager;
import fr.eni.projetjee.TrocEncheres.bll.UtilisateurManagerException;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

@WebServlet("/ServletNouvelleVente")
public class ServletNouvelleVente extends HttpServlet {
	private ICategorieManager categorieManager = SingletonCategorieManager.getInstance();
	private IArticleVenduManager articleManager = SingletonArticleVenduManager.getInstance();

	private static final long serialVersionUID = 1L;

	public ServletNouvelleVente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("./NouvelleVente.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String nomArticle = request.getParameter("nom-article");
		String description = request.getParameter("description");
		String categorie = request.getParameter("categorie");
		Categorie categorieVerif = null;
		
		System.out.println(categorie);
		
		try {
			
			categorieVerif = checkCategorie(categorie);
			
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String miseAPrix = request.getParameter("mise-a-prix");
		Integer miseAprix = Integer.parseInt(miseAPrix);
		LocalDate debutEnchere;
		LocalDate finEnchere;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		debutEnchere = LocalDate.parse(request.getParameter("debut-enchere"), dtf);
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		finEnchere = LocalDate.parse(request.getParameter("fin-enchere"), dtf2);
		Integer prixDeVente = 0;
		Boolean etatVente = false;

		Utilisateur user = (Utilisateur) session.getAttribute("utilisateur");

		
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code-postal");
		String ville = request.getParameter("ville");

		Retrait nouveauRetrait = new Retrait(rue, codePostal, ville);
		
		ArticleVendu nouvelArticle = new ArticleVendu(nomArticle, description, debutEnchere, finEnchere, miseAprix,
				prixDeVente, etatVente, nouveauRetrait, user, categorieVerif);
		
		Integer idArticle = 0;
		
		try {
			
			articleManager.insertArticle(nouvelArticle);
			idArticle = nouvelArticle.getNoArticle();
			
		
		} catch (ArticleVenduManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.setAttribute("article", nouvelArticle);
		RequestDispatcher rd = request.getRequestDispatcher("./DetailVente.jsp");

		rd.forward(request, response);
	
	}

	public Categorie checkCategorie(String libelle) throws DALException {
		
		Categorie categorie = null;
		List<Categorie> maListe = new ArrayList<>();
		
		try {
			maListe = categorieManager.selectAll();
		} catch (DALException e) {
			e.printStackTrace();
		} catch (UtilisateurManagerException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < maListe.size(); i++) {
			if (libelle.equalsIgnoreCase(maListe.get(i).getLibelle())) {
				categorie = maListe.get(i);
			}
		}

		return categorie;
	}

}
