package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bll.ArticleVenduManagerException;
import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;

public interface IArticleVenduDAO {

	public void insertArticleVendu(ArticleVendu article) throws ArticleVenduManagerException, DALException, SQLException  ;
	
	public void updateArticleVendu(ArticleVendu article) throws ArticleVenduManagerException, DALException, SQLException ;
	
	public void updatePdv(ArticleVendu article) throws ArticleVenduManagerException, DALException, SQLException ;
	
	public void deleteArticleVendu(Integer noArticle) throws ArticleVenduManagerException, DALException, SQLException ;
	
	public ArticleVendu selectById(Integer noArticle) throws ArticleVenduManagerException, DALException, SQLException ;
	
	public List<ArticleVendu> selectByCategorie(String type) throws ArticleVenduManagerException, DALException, SQLException;

	public List<ArticleVendu> selectAll() throws ArticleVenduManagerException, DALException, SQLException ;


}
