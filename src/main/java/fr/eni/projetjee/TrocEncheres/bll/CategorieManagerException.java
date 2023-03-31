package fr.eni.projetjee.TrocEncheres.bll;

public class CategorieManagerException extends Exception {

		private static final long serialVersionUID = 1L;
	
		public CategorieManagerException() {
			super();
		}
		
		public CategorieManagerException(String message) {
			super(message);
		}
		
		public  CategorieManagerException(String message, Throwable exception) {
			super(message, exception);
		}
	
		@Override
		public String getMessage() {
			StringBuffer sb = new StringBuffer("Couche BLL - ");
			sb.append(super.getMessage());
			
			return sb.toString() ;
		}

}
