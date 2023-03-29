package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

public interface IUtilisateurDAO {
	
	public void insertUtilisateur(Utilisateur utilisateur ) throws DALException, SQLException  ;
	
	public void updateUtilisateur(Utilisateur utilisateur ) throws DALException, SQLException ;
	
	public void deleteUtilisateur(Integer noUtilisateur ) throws DALException, SQLException ;
	
	public Utilisateur selectById(Integer noUtilisateur ) throws DALException, SQLException ;
	
	
}
