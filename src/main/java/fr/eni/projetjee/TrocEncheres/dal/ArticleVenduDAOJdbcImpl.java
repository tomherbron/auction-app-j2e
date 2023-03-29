package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;

public class ArticleVenduDAOJdbcImpl {

	private static final String INSERT = "INSERT INTO article_vendu(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE article_vendu SET nom_article=?, description=?, date_debut_enchere=?,date_fin_enchere=?, prix_initial=?,prix_vente=? WHERE no_article=?";
	private static final String DELETE = "DELETE FROM article_vendu WHERE no_article=?";
	private static final String SELECTBYID = "SELECT (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie) FROM article_vendu WHERE no_article=? )";

	public void insertArticleVendu(ArticleVendu article) throws DALException, SQLException {

		if (article == null) {

			// TODO

		}
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEnchere()));
			pstmt.setDate(4, Date.valueOf(article.getDateFinEnchere()));
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setInt(6, article.getPrixDeVente());
			pstmt.setBoolean(7, article.getEtatVente());
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				article.setNoArticle((rs.getInt(1)));
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}
}
