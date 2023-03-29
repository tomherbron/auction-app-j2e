package fr.eni.projetjee.TrocEncheres.bll;

public class SingletonUtilisateurManager {
	
	private static IUtilisateurManager instance;
	
	public static IUtilisateurManager getInstance() {
		
		if (instance == null) {
			instance = new UtilisateurManager();
		}
		return instance;
	}

}
