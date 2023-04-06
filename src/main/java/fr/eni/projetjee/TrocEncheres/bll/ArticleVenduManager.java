package fr.eni.projetjee.TrocEncheres.bll;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.ArticleVenduDAOJdbcImpl;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;

public class ArticleVenduManager implements IArticleVenduManager{

	private ArticleVenduDAOJdbcImpl articleVenduDAO = DAOFactory.getArticleVenduDAO();

	
	@Override
	public void insertArticle(ArticleVendu article) throws ArticleVenduManagerException {
		
		try {

			
			articleVenduDAO.insertArticleVendu(article);
			
		} catch (DALException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ArticleVenduManagerException("select All failed.");
		
		}

	}

	@Override
	public void updateArticle(ArticleVendu article) throws ArticleVenduManagerException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteArticle(Integer noArticle) throws ArticleVenduManagerException {
		// TODO Auto-generated method stub

	}

	@Override
	public ArticleVendu selectById(Integer noArticle) throws ArticleVenduManagerException {

		ArticleVendu article = null;

		try {

			article = articleVenduDAO.selectById(noArticle);

		} catch (DALException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ArticleVenduManagerException("select All failed.");
		}

		return article;

	}

	@Override
	public List<ArticleVendu> selectAll() throws  ArticleVenduManagerException {
		List<ArticleVendu> listeArticles = null;

		try {

			listeArticles = articleVenduDAO.selectAll();

		} catch (DALException | SQLException e) {
			e.printStackTrace();
			throw new ArticleVenduManagerException("select All failed.");

		}

		return listeArticles;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(String type) throws ArticleVenduManagerException {

		List<ArticleVendu> listeArticles = null;

		try {

			listeArticles = articleVenduDAO.selectByCategorie(type);

		} catch (DALException | SQLException e) {
			e.printStackTrace();
			throw new ArticleVenduManagerException("select by categorie.");

		}

		return listeArticles;
	}

	@Override

	public void updatePdv(ArticleVendu article) throws DALException, ArticleVenduManagerException {
		
		try {
			
			articleVenduDAO.updatePdv(article);
			
		} catch (DALException | SQLException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public List<ArticleVendu> selectByEtatVente(String vente) throws ArticleVenduManagerException {

			
		
			

			List<ArticleVendu> listeArticles = null;

			try {

				listeArticles = 	articleVenduDAO.selectByEtatVente(vente);

			} catch (DALException | SQLException e) {
				e.printStackTrace();
				throw new ArticleVenduManagerException("select by etat de la Vente");

			}

			return listeArticles;
		}
	
	
	
	
}
