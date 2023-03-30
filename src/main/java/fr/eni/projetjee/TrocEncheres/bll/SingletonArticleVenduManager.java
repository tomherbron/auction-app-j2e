package fr.eni.projetjee.TrocEncheres.bll;

public class SingletonArticleVenduManager {

	private static IArticleVenduManager instance;
	
	public static IArticleVenduManager getInstance() {
		if (instance ==null) {
			instance = new ArticleVenduManager();
		}
		return instance;
	}
}
