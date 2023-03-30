package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Retrait;

public class RetraitDAOJdbcImpl {

	// update avec le no_article comme condition
	private static final String UPDATE = "UPDATE retrait SET rue=?, code_postal=?, ville=? WHERE no_article=?";

	// select avec le no_article comme condition
	private static final String SELECT = "SELECT ( rue, code_postal, ville) FROM retrait WHERE no_article=? )";

	public void updateRetrait(Retrait retrait) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCodePostal());
			pstmt.setString(3, retrait.getVille());
			pstmt.executeUpdate();
			pstmt.close();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}
	
	
}
