package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Enchere;
import fr.eni.projetjee.TrocEncheres.dal.DALException;

public interface IEnchereManager {
	
	public void insertEnchere (Enchere enchere) throws DALException, SQLException;
	
	public void updateEnchere (Enchere enchere) throws DALException, SQLException;
	
	public void deleteEnchere (Integer noEnchere) throws DALException, SQLException;
	
	public List<Enchere> selectAllEncheres () throws DALException, SQLException;
	
	public Enchere selectEnchereById (Integer noEnchere) throws DALException, SQLException;
	
}
