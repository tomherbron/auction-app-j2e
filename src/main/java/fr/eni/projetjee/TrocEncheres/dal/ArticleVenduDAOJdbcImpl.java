package fr.eni.projetjee.TrocEncheres.dal;

public class ArticleVenduDAOJdbcImpl {

	
	private static final String INSERT = "INSERT INTO article_vendu(nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE article_vendu SET nom_article=?, description=?, date_debut_enchere=?,date_fin_enchere=?, prix_initial=?,prix_vente=? WHERE no_article=?";
	private static final String DELETE = "DELETE FROM article_vendu WHERE no_article=?";
	private static final String SELECTBYID= "SELECT (nom_article, description, date_debut_enchere, date_fin_enchere, prix_initial, prix_vente, no_utilisateur, no_categorie) FROM article_vendu WHERE no_article=? )";
	
}
