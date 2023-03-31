package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projetjee.TrocEncheres.bo.Categorie;

public class CategorieDAOJdbcImpl {

	private static final String SELECT_BY_ID = "SELECT (libelle) FROM categorie WHERE no_categorie=?";
	private static final String SELECT_ALL = "SELECT * FROM categorie";
	

	
	public Categorie selectById(Integer noCategorie) throws DALException, SQLException {
		Categorie categorie = null;

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, noCategorie);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				noCategorie = rs.getInt(1);
				String libelle = rs.getString(2);
							
				categorie = new Categorie (libelle);
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Select by Id");
		}

		return categorie;
		
	}
	

	public List<Categorie> selectAll() throws DALException, SQLException {
		List<Categorie> categories = null;

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String libelle = rs.getString(2);
							
				categories = new ArrayList<Categorie>();
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Select by Id");
		}

		return categories;
		
	}
	
	public void insertCategorie(Categorie categorie) throws DALException, SQLException {
		//TODO		
		
	} 
	

	
	
	
}