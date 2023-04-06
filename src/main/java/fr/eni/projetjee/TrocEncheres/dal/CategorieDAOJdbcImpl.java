package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import fr.eni.projetjee.TrocEncheres.bo.Categorie;

public class CategorieDAOJdbcImpl implements ICategorieDAO {

	private static final String SELECT_BY_ID = "SELECT (libelle) FROM categorie WHERE no_categorie=?";
	private static final String SELECT_ALL = "SELECT `no_categorie`, `libelle` FROM `categorie`";
	

	
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
		List<Categorie> catList = new ArrayList<>();
		Categorie categorie = null;

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Integer noCategorie = rs.getInt(1);
				String libelle = rs.getString(2);
				
				categorie = new Categorie(noCategorie, libelle);
				
				catList.add(categorie);
				
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectAll");
		}

		return catList;
		
	}
	
	
}
