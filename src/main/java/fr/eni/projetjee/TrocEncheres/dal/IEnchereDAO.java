package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Enchere;

public interface IEnchereDAO {
	
	public void insertEnchere (Enchere enchere) throws DALException, SQLException;
	
	public void updateEnchere (Enchere enchere) throws DALException, SQLException;
	
	public void deleteEnchere (Integer noEnchere) throws DALException, SQLException;
	
	public void selectAllEncheres () throws DALException, SQLException;
	
	public void selectEnchereById (Integer noEnchere) throws DALException, SQLException;
	
}
