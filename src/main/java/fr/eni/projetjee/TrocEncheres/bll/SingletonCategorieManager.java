package fr.eni.projetjee.TrocEncheres.bll;

public class SingletonCategorieManager {

	private static ICategorieManager instance;
	
	public static ICategorieManager getInstance() {
		if (instance ==null) {
			instance = new CategorieManager();
		}
		return instance;
	}
}
