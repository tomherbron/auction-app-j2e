package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;

public class RetraitDAOJdbcImpl {

	private static final String UPDATE = "UPDATE retrait SET rue=?, code_postal=?, ville=? WHERE no_article=?";
	private static final String SELECT_BY_ID = "SELECT `r`.`rue` AS `rue`, `r`.`code_postal` AS `code_postal`, `a`.`no_article` AS `no_article` FROM `retrait` AS `r`INNER JOIN `article_vendu` AS `a` ON `a`.`no_article` = `r`.`no_article` WHERE `r`.`no_article` = ?";
	private static final String INSERT_RETRAIT = "INSERT INTO retrait(no_article, rue, code_postal, ville) VALUES(?,?,?,?)";

	public void updateRetrait(Retrait retrait) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, retrait.getRue());
			pstmt.setString(2, retrait.getCodePostal());
			pstmt.setString(3, retrait.getVille());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update failed");
		}

	}

	public void selectRetrait(Integer noArticle) throws DALException, SQLException {
		
		Retrait retrait = null;
		
		try (Connection con = ConnectionProvider.getConnection()) {
			
			PreparedStatement psmt = con.prepareStatement(SELECT_BY_ID);
			psmt.setInt(1, noArticle);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				String rue = rs.getString(1);
				String cpo = rs.getString(2);
				String ville = rs.getString(3);
				noArticle= rs.getInt(4);
				
				retrait = new Retrait (rue, cpo, ville);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("selectById failed");
		}

	}
	
	public void insertRetrait(Retrait retrait, Integer noArticleVendu) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			
			PreparedStatement pstmt = con.prepareStatement(INSERT_RETRAIT);
			
			pstmt.setInt(1, noArticleVendu);
			pstmt.setString(2, retrait.getRue());
			pstmt.setString(3, retrait.getCodePostal());
			pstmt.setString(4, retrait.getVille());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}
}
