package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface ICategorieManager {

	public void selectById(Integer noCategorie) throws DALException, SQLException;

	public void selectAll() throws DALException, SQLException;
	
	public void insertCategorie(Categorie categorie) throws DALException, SQLException; 
	
	
	
	
}
