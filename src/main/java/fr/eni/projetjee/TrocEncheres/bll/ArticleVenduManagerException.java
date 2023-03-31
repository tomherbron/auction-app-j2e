package fr.eni.projetjee.TrocEncheres.bll;

public class ArticleVenduManagerException extends Exception {

	private static final long serialVersionUID = 1L;

	public ArticleVenduManagerException() {
		super();
	}
	
	public ArticleVenduManagerException(String message) {
		super(message);
	}
	
	public  ArticleVenduManagerException(String message, Throwable exception) {
		super(message, exception);
	}

	@Override
	public String getMessage() {
		StringBuffer sb = new StringBuffer("Couche BLL - ");
		sb.append(super.getMessage());
		
		return sb.toString() ;
	}
	
}