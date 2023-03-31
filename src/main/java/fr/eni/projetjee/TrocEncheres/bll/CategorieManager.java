package fr.eni.projetjee.TrocEncheres.bll;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;
import fr.eni.projetjee.TrocEncheres.dal.CategorieDAOJdbcImpl;
import fr.eni.projetjee.TrocEncheres.dal.DALException;
import fr.eni.projetjee.TrocEncheres.dal.DAOFactory;
import fr.eni.projetjee.TrocEncheres.dal.UtilisateurDAOJdbcImpl;

public class CategorieManager implements ICategorieManager {
	
	private CategorieDAOJdbcImpl categorieDAO = DAOFactory.getCategorieDAO();

	@Override
	public void selectById(Integer noCategorie) throws DALException, UtilisateurManagerException {
				
	}

	@Override
	public void insertCategorie(Categorie categorie) throws DALException, UtilisateurManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categorie> selectAll() throws DALException, UtilisateurManagerException {
		List<Categorie> catList = new ArrayList<>();
		
		try {
			
			catList = categorieDAO.selectAll();			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new UtilisateurManagerException("selectAll failed.");
		}
		return catList;
		
	}	
		
		
		
		
	
	

}
