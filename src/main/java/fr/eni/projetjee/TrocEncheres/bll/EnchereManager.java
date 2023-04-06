package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Enchere;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;
import fr.eni.projetjee.TrocEncheres.dal.IEnchereDAO;

public class EnchereManager implements IEnchereManager {
	
	IEnchereDAO enchereDAO = DAOFactory.getEnchereDAO();

	@Override
	public void insertEnchere(Enchere enchere) throws DALException, SQLException {
		
		enchereDAO.insertEnchere(enchere);
		
	}

	@Override
	public void updateEnchere(Enchere enchere) throws DALException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEnchere(Integer noEnchere) throws DALException, SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> selectAllEncheres() throws DALException, SQLException {
		List<Enchere> lstEncheres = new ArrayList<>();
		
		lstEncheres = enchereDAO.selectAllEncheres();
		
		return lstEncheres;
	}

	@Override
	public Enchere selectEnchereById(Integer noEnchere) throws DALException, SQLException {
		Enchere enchere = null;
		
		enchere = enchereDAO.selectEnchereById(noEnchere);
		
		return enchere;
		
	}

}
