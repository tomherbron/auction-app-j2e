package fr.eni.projetjee.TrocEncheres.dal;

public class DAOFactory {
	
	public static UtilisateurDAOJdbcImpl getUtilisateurDAO () {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleVenduDAOJdbcImpl getArticleDAO () {
		return new ArticleVenduDAOJdbcImpl();
		
	}
	
	public static EnchereDAOJdbcImpl getEnchereDAO () {
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAOJdbcImpl getRetraitDAO () {
		return new RetraitDAOJdbcImpl();
	}

}
