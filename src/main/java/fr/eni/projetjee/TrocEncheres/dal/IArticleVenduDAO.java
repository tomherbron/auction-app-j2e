package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;

public interface IArticleVenduDAO {

	public void insertArticleVendu(ArticleVendu article) throws DALException, SQLException  ;
	
	public void updateArticleVendu(ArticleVendu article) throws DALException, SQLException ;
	
	public void updatePdv(ArticleVendu article) throws DALException, SQLException ;
	
	public void deleteArticleVendu(Integer noArticle) throws DALException, SQLException ;
	
	public ArticleVendu selectById(Integer noArticle) throws DALException, SQLException ;

<<<<<<< HEAD
	public List<ArticleVendu>  selectAll() throws DALException, SQLException ;
	
	public List<ArticleVendu> selectByCategorie(String type) throws DALException, SQLException;
=======
	public List<ArticleVendu> selectAll() throws DALException, SQLException ;

>>>>>>> branch 'master' of https://github.com/tomyonearth/trocEncheres
}
