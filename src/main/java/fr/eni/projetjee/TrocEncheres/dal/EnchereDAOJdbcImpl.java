package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetjee.TrocEncheres.bo.ArticleVendu;
import fr.eni.projetjee.TrocEncheres.bo.Categorie;
import fr.eni.projetjee.TrocEncheres.bo.Enchere;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

public class EnchereDAOJdbcImpl implements IEnchereDAO {

	private static final String INSERT = "INSERT INTO enchere(date_enchere, montant_enchere, no_article, no_utilisateur) VALUES(?,?,?,?)";
	private static final String UPDATE = "UPDATE enchere SET date_enchere=?, montant_enchere=?, no_article=?, no_utilisateur=? WHERE no_enchere=?";
	private static final String DELETE = "DELETE FROM enchere WHERE no_enchere=?";
	private static final String SELECTALL = "SELECT * FROM enchere LEFT JOIN article_vendu on article_vendu.no_article = enchere.no_article LEFT JOIN utilisateur on article_vendu.no_utilisateur = utilisateur.no_utilisateur ";
	private static final String SELECTBYID =  "SELECT * FROM  enchere LEFT JOIN article_vendu on article_vendu.no_article = enchere.no_article LEFT JOIN utilisateur on article_vendu.no_utilisateur = utilisateur.no_utilisateur WHERE no_enchere = ?";
	private static final String SELECTBYNOARTICLE = "SELECT * FROM enchere LEFT JOIN article_vendu on article_vendu.no_article = enchere.no_article LEFT JOIN utilisateur on article_vendu.no_utilisateur = utilisateur.no_utilisateur WHERE no_article=?;";
	
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
		
		try (Connection con = ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement(SELECTALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				   Enchere enchereCourante = enchereBuilder(rs);
					listeEnchere.add(enchereCourante);
			}
			pstmt.close(); 
		}
			catch (SQLException e) 
			{
				e.printStackTrace();
				throw new DALException("SelectAll failed");	
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
				
				Integer noArticle = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEnchere = rs.getDate("date_debut_enchere").toLocalDate();
				LocalDate dateFinEnchere = rs.getDate("date_fin_enchere").toLocalDate();
				Integer miseAPrix = rs.getInt("prix_initial");
				Integer prixDeVente = rs.getInt("prix_vente");
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				Integer noCategorie = rs.getInt("no_categorie");
				Boolean etatVente = rs.getBoolean("etat_vente");
				String rue = rs.getNString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getNString("ville");
				String libelle = rs.getNString("libelle");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String motDePasse = rs.getString("mot_de_passe");
				Integer credit = rs.getInt("credit");
				Boolean administrateur = rs.getBoolean("administrateur");
				
				Categorie cat = new Categorie (noCategorie, libelle);
				Retrait ret = new Retrait (rue, codePostal, ville);
				Utilisateur user = new Utilisateur (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);

				ArticleVendu article = new ArticleVendu(noArticle, nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, prixDeVente, etatVente, ret, user, cat);
			
				enchere = new Enchere (noEnchere, dateEnchere, montantEnchere, user, article);

				pstmt.close();

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectEnchereById failed");
		}

		return enchere;

	}
	
	@Override
	public Enchere selectEnchereByNoArticle(Integer noArticle) throws DALException, SQLException {
		Enchere enchere = null;
		
		try (Connection con = ConnectionProvider.getConnection()){
			
			PreparedStatement pstmt = con.prepareStatement(SELECTBYNOARTICLE);
			pstmt.setInt(1, noArticle);
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				Integer noEnchere = rs.getInt(1);
				LocalDate dateEnchere = rs.getDate(2).toLocalDate();
				int montantEnchere = rs.getInt(3);
				
				noArticle = rs.getInt("no_article");
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutEnchere = rs.getDate("date_debut_enchere").toLocalDate();
				LocalDate dateFinEnchere = rs.getDate("date_fin_enchere").toLocalDate();
				Integer miseAPrix = rs.getInt("prix_initial");
				Integer prixDeVente = rs.getInt("prix_vente");
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				Integer noCategorie = rs.getInt("no_categorie");
				Boolean etatVente = rs.getBoolean("etat_vente");
				String rue = rs.getNString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getNString("ville");
				String libelle = rs.getNString("libelle");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String motDePasse = rs.getString("mot_de_passe");
				Integer credit = rs.getInt("credit");
				Boolean administrateur = rs.getBoolean("administrateur");
				
				Categorie cat = new Categorie (noCategorie, libelle);
				Retrait ret = new Retrait (rue, codePostal, ville);
				Utilisateur user = new Utilisateur (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);

				ArticleVendu article = new ArticleVendu(noArticle, nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, prixDeVente, etatVente, ret, user, cat);
			
				enchere = new Enchere (noEnchere, dateEnchere, montantEnchere, user, article);
			}
				pstmt.close();
				
		} catch (SQLException e) {
				e.printStackTrace();
				throw new DALException("SelectEnchereByNoArticlefailed");
		}
		
		return enchere;
	}

	private Enchere enchereBuilder(ResultSet rs) throws SQLException {
		Enchere enchereCourante;
	
		enchereCourante = new Enchere();
		enchereCourante.setNoEnchere(rs.getInt("no_enchere"));
		enchereCourante.setDateEnchere(rs.getDate("date_enchere").toLocalDate());
		enchereCourante.setMontantEnchere(rs.getInt("montant_enchere")); 
		
		Integer noArticle = rs.getInt("no_article");
		String nomArticle = rs.getString("nom_article");
		String description = rs.getString("description");
		LocalDate dateDebutEnchere = rs.getDate("date_debut_enchere").toLocalDate();
		LocalDate dateFinEnchere = rs.getDate("date_fin_enchere").toLocalDate();
		Integer miseAPrix = rs.getInt("prix_initial");
		Integer prixDeVente = rs.getInt("prix_vente");
		Integer noUtilisateur = rs.getInt("no_utilisateur");
		Integer noCategorie = rs.getInt("no_categorie");
		Boolean etatVente = rs.getBoolean("etat_vente");
		String rue = rs.getNString("rue");
		String codePostal = rs.getString("code_postal");
		String ville = rs.getNString("ville");
		String pseudo = rs.getString("pseudo");
		String nom = rs.getString("nom");
		String prenom = rs.getString("prenom");
		String email = rs.getString("email");
		String telephone = rs.getString("telephone");
		String motDePasse = rs.getString("mot_de_passe");
		Integer credit = rs.getInt("credit");
		Boolean administrateur = rs.getBoolean("administrateur");
		
		Categorie cat = new Categorie (noCategorie, null);
		Retrait ret = new Retrait (rue, codePostal, ville);
		Utilisateur user = new Utilisateur (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);

		ArticleVendu article = new ArticleVendu(noArticle, nomArticle, description, dateDebutEnchere, dateFinEnchere, miseAPrix, prixDeVente, etatVente, ret, user, cat);
	
		
		enchereCourante.setArticle(article);
		enchereCourante.setUtilisateur(user);
		
		return enchereCourante;
	}


}
