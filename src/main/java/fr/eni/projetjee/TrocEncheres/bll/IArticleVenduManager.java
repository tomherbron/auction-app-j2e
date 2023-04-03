package fr.eni.projetjee.TrocEncheres.bll;


import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IArticleVenduManager {

	public void insertArticle(ArticleVendu article ) throws DALException, ArticleVenduManagerException;
	
	public void updateArticle(ArticleVendu article ) throws DALException, ArticleVenduManagerException;
	
	public void deleteArticle(Integer noArticle ) throws DALException, ArticleVenduManagerException;
	
	public ArticleVendu selectById(Integer noArticle ) throws DALException, ArticleVenduManagerException;

	public List<ArticleVendu> selectAll() throws DALException, ArticleVenduManagerException ;
}
