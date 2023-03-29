package fr.eni.projetjee.TrocEncheres.bll;

public class UtilisateurManagerException extends Exception {


	private static final long serialVersionUID = 1L;

	public UtilisateurManagerException() {
		super();
	}
	
	public UtilisateurManagerException(String message) {
		super(message);
	}
	
	public  UtilisateurManagerException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
	
}
