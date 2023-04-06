package fr.eni.projetjee.TrocEncheres.bll;

import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IUtilisateurManager {
	
	public void insertUtilisateur(Utilisateur utilisateur ) throws DALException, UtilisateurManagerException;
	
	public void updateUtilisateur(Utilisateur utilisateur ) throws DALException, UtilisateurManagerException ;
	
	public void deleteUtilisateur(Integer noUtilisateur ) throws DALException, UtilisateurManagerException ;
	
	public Utilisateur  selectById(Integer noUtilisateur ) throws DALException, UtilisateurManagerException ;
	
	public Utilisateur  selectByLogin (String pseudo, String motDePasse) throws DALException, UtilisateurManagerException;
	
	public List <Utilisateur> selectAll() throws DALException, UtilisateurManagerException;
	
	public Utilisateur  selectByPseudo (String pseudo) throws DALException, UtilisateurManagerException;

}
