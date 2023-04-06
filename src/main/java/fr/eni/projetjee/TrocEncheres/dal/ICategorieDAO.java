package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Categorie;

public interface ICategorieDAO {
	
	public Categorie selectById(Integer noCategorie) throws DALException, SQLException;
		
	public List<Categorie> selectAll() throws DALException, SQLException; 
		
}
