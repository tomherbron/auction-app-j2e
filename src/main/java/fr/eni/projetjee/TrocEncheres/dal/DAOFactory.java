package fr.eni.projetjee.TrocEncheres.dal;

public class DAOFactory {
	
	public static UtilisateurDAOJdbcImpl getUtilisateurDAO () {
		return new UtilisateurDAOJdbcImpl();
	}
	
	public static ArticleVenduDAOJdbcImpl getArticleVenduDAO () {
		return new ArticleVenduDAOJdbcImpl();	
	}
	
	public static EnchereDAOJdbcImpl getEnchereDAO () {
		return new EnchereDAOJdbcImpl();
	}
	
	public static RetraitDAOJdbcImpl getRetraitDAO () {
		return new RetraitDAOJdbcImpl();
	}

	public static CategorieDAOJdbcImpl getCategorieDAO() {
		return new CategorieDAOJdbcImpl();
		
	}
	
}
