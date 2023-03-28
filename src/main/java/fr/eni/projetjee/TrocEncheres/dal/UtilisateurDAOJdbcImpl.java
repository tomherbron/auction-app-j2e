package fr.eni.projetjee.TrocEncheres.dal;

public class UtilisateurDAOJdbcImpl {
	
	private static final String INSERT = "INSERT INTO utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE utilisateur SET pseudo=?, nom=?, prenom=?,email=?, telephone=?,rue=?,code_postal=?, ville=?,mot_de_passe=?WHERE no_utilisateur=?";
	private static final String DELETE= "DELETE FROM Utilisateur WHERE no_utilisateur=?";
	private static final String SELECTBYID= "SELECT (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit) FROM utilisateur WHERE no_utilisateur=? )";
	
}
