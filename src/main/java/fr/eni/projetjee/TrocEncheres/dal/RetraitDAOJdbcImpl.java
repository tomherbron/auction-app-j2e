package fr.eni.projetjee.TrocEncheres.dal;

public class RetraitDAOJdbcImpl {

	
	//update avec le no_article comme condition
		private static final String UPDATE = "UPDATE retrait SET rue=?, code_postal=?, ville=? WHERE no_article=?";
		
	//select avec le no_article comme condition
		private static final String SELECT= "SELECT ( rue, code_postal, ville) FROM retrait WHERE no_article=? )";

	
}
