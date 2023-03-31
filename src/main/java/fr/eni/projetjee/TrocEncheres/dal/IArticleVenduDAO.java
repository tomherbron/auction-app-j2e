package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;

public interface IArticleVenduDAO {
	
	public void insertArticleVendu(ArticleVendu article) throws DALException, SQLException  ;
	
	public void updateArticleVendu(ArticleVendu article) throws DALException, SQLException ;
	
	public void deleteArticleVendu(Integer noArticle) throws DALException, SQLException ;
	
	public ArticleVendu selectById(Integer noArticle) throws DALException, SQLException ;

	public ArticleVendu selectAll() throws DALException, SQLException ;
}
