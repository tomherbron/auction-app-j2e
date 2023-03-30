package fr.eni.projetjee.TrocEncheres.bll;


import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IArticleVenduManager {
	public void insertArticle(ArticleVendu article ) throws DALException, UtilisateurManagerException;
	
	public void updateArticle(ArticleVendu article ) throws DALException, UtilisateurManagerException;
	
	public void deleteArticle(Integer noArticle ) throws DALException, UtilisateurManagerException;
	
	public ArticleVendu selectById(Integer noArticle ) throws DALException, UtilisateurManagerException;
}
