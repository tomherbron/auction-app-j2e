package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.ArticleVenduDAOJdbcImpl;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;
import fr.eni.projetjee.TrocEncheres.dal.UtilisateurDAOJdbcImpl;

public class ArticleVenduManager implements IArticleVenduManager{

	private ArticleVenduDAOJdbcImpl articleVenduDAO = DAOFactory.getArticleVenduDAO();

	
	@Override
	public void insertArticle(ArticleVendu article) throws DALException, ArticleVenduManagerException {
		
		try {
			articleVenduDAO.insertArticleVendu(article);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateArticle(ArticleVendu article) throws DALException, ArticleVenduManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(Integer noArticle) throws DALException, ArticleVenduManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArticleVendu selectById(Integer noArticle) throws DALException, ArticleVenduManagerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectAll() throws DALException, ArticleVenduManagerException {
		List<ArticleVendu> listeArticles = new ArrayList<>();
		
		try {
			
			listeArticles = articleVenduDAO.selectAll();
					
		}catch (DALException | SQLException e) {
			e.printStackTrace();
			throw new ArticleVenduManagerException("select All failed.");
		
		
		
	}
		
		
		return listeArticles;
	
	
}
}
