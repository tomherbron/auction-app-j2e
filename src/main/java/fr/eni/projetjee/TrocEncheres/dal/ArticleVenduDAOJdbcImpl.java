package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;

public class ArticleVenduDAOJdbcImpl {
	
	private static final String INSERT_ARTICLE_VENDU = "INSERT INTO article_vendu(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) VALUES(?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE article_vendu SET nom_article=?, description=?, date_debut_enchere=?,date_fin_enchere=?, prix_initial=?,prix_vente=?, etat_vente =? WHERE no_article=?";
	private static final String DELETE = "DELETE FROM article_vendu WHERE no_article=?";
	private static final String SELECT_BY_ID = "SELECT (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie) FROM article_vendu WHERE no_article=?";
	private static final String SELECT_ALL = "SELECT * FROM article_vendu";
	
	
	
	public void insertArticleVendu(ArticleVendu article) throws DALException, SQLException {
		
		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(INSERT_ARTICLE_VENDU, PreparedStatement.RETURN_GENERATED_KEYS);

			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEnchere()));
			pstmt.setDate(4, Date.valueOf(article.getDateFinEnchere()));
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setInt(6, article.getPrixDeVente());
			pstmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, article.getCategorie().getNoCategorie());
			pstmt.setBoolean(9, article.getEtatVente());
			
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if (rs.next()) {
				article.setNoArticle(rs.getInt(1));
				System.out.println(article.getNoArticle());
			}
			
			rs.close();
			pstmt.close();
			
			Retrait retrait = new Retrait();

			retrait.setRue(article.getRetrait().getRue());
			retrait.setCodePostal(article.getRetrait().getCodePostal());
			retrait.setVille(article.getRetrait().getVille());
			System.out.println(retrait);
			
			 DAOFactory.getRetraitDAO() .insertRetrait(retrait, article.getNoArticle());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}

	public void updateArticleVendu(ArticleVendu article) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, article.getNomArticle());
			pstmt.setString(2, article.getDescription());
			pstmt.setDate(3, Date.valueOf(article.getDateDebutEnchere()));
			pstmt.setDate(4, Date.valueOf(article.getDateFinEnchere()));
			pstmt.setInt(5, article.getMiseAPrix());
			pstmt.setInt(6, article.getPrixDeVente());
			pstmt.setInt(7, article.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(8, article.getCategorie().getNoCategorie());
			pstmt.setBoolean(9, article.getEtatVente());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}

	public void deleteArticleVendu(Integer noArticle) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(DELETE);
			pstmt.setInt(1, noArticle);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}

	}

	public ArticleVendu selectById(Integer noArticle) throws DALException, SQLException {
		ArticleVendu article = null;

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				noArticle = rs.getInt(1);
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDate dateDebutEnchere = rs.getDate(4).toLocalDate();
				LocalDate dateFinEnchere = rs.getDate(5).toLocalDate();
				Integer miseAPrix = rs.getInt(6);
				Integer prixDeVente = rs.getInt(7);
				Boolean etatVente = rs.getBoolean(10);
				
				
				article = new ArticleVendu(nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix,prixDeVente, article.getUtilisateur(),article.getCategorie(), etatVente);
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("select by id failed");
		}

		return article;
	}
	public List<ArticleVendu> selectAll() throws DALException, SQLException {
		List<ArticleVendu> listeArticleVendu = null;

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				int noArticle = rs.getInt(1);
				String nomArticle = rs.getString(2);
				String description = rs.getString(3);
				LocalDate dateDebutEnchere = rs.getDate(4).toLocalDate();
				LocalDate dateFinEnchere = rs.getDate(5).toLocalDate();
				Integer miseAPrix = rs.getInt(6);
				Integer prixDeVente = rs.getInt(7);
				Boolean etatVente = rs.getBoolean(10);
							
				listeArticleVendu = new ArrayList<ArticleVendu>();
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Select All");
		}

		return listeArticleVendu;
		
	}
}
