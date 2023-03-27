package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;



public interface IRetraitDAO {
	
	public void updateRetrait(Integer noArticle) throws DALException, SQLException  ;
	
	public void selectRetrait(Integer noArticle) throws DALException, SQLException  ;
	
}
