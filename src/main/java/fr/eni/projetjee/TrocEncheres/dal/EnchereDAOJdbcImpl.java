package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.Enchere;

public class EnchereDAOJdbcImpl implements IEnchereDAO {

	private static final String INSERT = "INSERT INTO enchere(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private static final String UPDATE = "UPDATE enchere SET date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? WHERE no_enchere=?";
	private static final String DELETE = "DELETE FROM enchere WHERE no_enchere=?";
	private static final String SELECTALL = "SELECT * FROM enchere";
	private static final String SELECTBYID = "SELECT (no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur) FROM enchere WHERE no_enchere=? )";

	@Override
	public void insertEnchere(Enchere enchere) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getArticle().getNoArticle());
			pstmt.setInt(4, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				enchere.setNoEnchere(rs.getInt(1));
			}
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème à l'insertion de l'enchère");

		}
	}

	@Override
	public void updateEnchere(Enchere enchere) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setDate(1, java.sql.Date.valueOf(enchere.getDateEnchere()));
			pstmt.setInt(2, enchere.getMontantEnchere());
			pstmt.setInt(3, enchere.getNoEnchere());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update failed");

		}
	}

	@Override
	public void deleteEnchere(Integer noEnchere) throws DALException, SQLException {
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, noEnchere);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Delete failed");

		}
	}

	@Override
	public List<Enchere> selectAllEncheres() throws DALException, SQLException {
		List<Enchere> listeEnchere = new ArrayList<Enchere>();
		try (Connection con = ConnectionProvider.getConnection())
		{
			PreparedStatement pstmt = con.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			Enchere enchereCourante = new Enchere();
			while(rs.next())
			{
				if(rs.getInt("no_enchere")!=enchereCourante.getNoEnchere())
				{
					enchereCourante = enchereBuilder(rs);
					listeEnchere.add(enchereCourante);
				}
				pstmt.close(); 
			}
		}
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new DALException("SelectEnchereById failed");	
		}
		return listeEnchere;
	}

	@Override
	public Enchere selectEnchereById(Integer noEnchere) throws DALException, SQLException {
		Enchere enchere = null;
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECTBYID);
			pstmt.setInt(1, noEnchere);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				noEnchere = rs.getInt(1);
				LocalDate dateEnchere = rs.getDate(2).toLocalDate();
				int montantEnchere = rs.getInt(3);
			

				pstmt.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectEnchereById failed");
		}

		return enchere;

	}

	private Enchere enchereBuilder(ResultSet rs) throws SQLException {
		Enchere enchereCourante;
		enchereCourante = new Enchere();
		enchereCourante.setNoEnchere(rs.getInt("no_enchere"));
		enchereCourante.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
		enchereCourante.setMontantEnchere(rs.getInt("montant_enchere"));
		return enchereCourante;
	}

}
