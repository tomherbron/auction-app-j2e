package fr.eni.projetjee.TrocEncheres.bll;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IUtilisateurManager {
	
	public void insertUtilisateur(Utilisateur utilisateur ) throws DALException, UtilisateurManagerException;
	
	public void updateUtilisateur(Utilisateur utilisateur ) throws DALException, UtilisateurManagerException ;
	
	public void deleteUtilisateur(Integer noUtilisateur ) throws DALException, UtilisateurManagerException ;
	
	public void selectById(Integer noUtilisateur ) throws DALException, UtilisateurManagerException ;

}
