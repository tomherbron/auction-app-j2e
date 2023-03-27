package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Categorie;

public interface ICategorieDAO {

		
		public void selectById(Integer noCategorie) throws DALException, SQLException;
		
		public void insertCategorie(Categorie categorie) throws DALException, SQLException; 
		
	
}
