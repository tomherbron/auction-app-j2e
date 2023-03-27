package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;


public interface IRetraitDAO {
	
	public void selectRetrait(Integer noArticle) throws DALException, SQLException  ;
	
}
