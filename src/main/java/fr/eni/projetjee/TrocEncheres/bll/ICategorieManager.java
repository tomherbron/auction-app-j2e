package fr.eni.projetjee.TrocEncheres.bll;

import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface ICategorieManager {

	public void selectById(Integer noCategorie) throws DALException, UtilisateurManagerException ;

	public void selectAll() throws DALException, UtilisateurManagerException;
	
	public void insertCategorie(Categorie categorie) throws DALException, UtilisateurManagerException; 
	
	
}
