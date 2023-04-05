package fr.eni.projetjee.TrocEncheres.bll;

public class SingletonEnchereManager {

	private static IEnchereManager instance;
	
	public static IEnchereManager getInstance() {
		
		if (instance == null) {
			instance = new EnchereManager();
		}
		return instance;
	}
	
}
