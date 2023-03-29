package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;
import fr.eni.projetjee.TrocEncheres.dal.UtilisateurDAOJdbcImpl;

public class UtilisateurManager implements IUtilisateurManager {
	
	private UtilisateurDAOJdbcImpl utilisateurDAO = DAOFactory.getUtilisateurDAO();

	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException, UtilisateurManagerException {
		
		try {
			
				utilisateurDAO.insertUtilisateur(utilisateur);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException, UtilisateurManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException, UtilisateurManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectById(Integer noUtilisateur) throws DALException, UtilisateurManagerException {
		// TODO Auto-generated method stub
		
	}

}
