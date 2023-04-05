package fr.eni.projetjee.TrocEncheres.bll;


import java.sql.SQLException;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IArticleVenduManager {

	public void insertArticle(ArticleVendu article ) throws ArticleVenduManagerException;
	
	public void updateArticle(ArticleVendu article ) throws ArticleVenduManagerException;
	
<<<<<<< HEAD
	public void deleteArticle(Integer noArticle ) throws ArticleVenduManagerException;
=======
	public void updatePdv(ArticleVendu article) throws DALException, ArticleVenduManagerException ;
	
	public void deleteArticle(Integer noArticle ) throws DALException, ArticleVenduManagerException;
>>>>>>> branch 'master' of https://github.com/tomyonearth/trocEncheres
	
	public ArticleVendu selectById(Integer noArticle ) throws ArticleVenduManagerException;

	public List<ArticleVendu> selectAll() throws ArticleVenduManagerException ;

	public List<ArticleVendu> selectByCategorie(String type)throws ArticleVenduManagerException;
	
}
