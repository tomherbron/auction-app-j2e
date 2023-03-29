package fr.eni.projetjee.TrocEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements IUtilisateurDAO {
	
	private static final String INSERT = "INSERT INTO utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE utilisateur SET pseudo=?, nom=?, prenom=?,email=?, telephone=?,rue=?,code_postal=?, ville=?,mot_de_passe=?WHERE no_utilisateur=?";
	private static final String DELETE= "DELETE FROM Utilisateur WHERE no_utilisateur=?";
	private static final String SELECTBYID= "SELECT (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit) FROM utilisateur WHERE no_utilisateur=? )";
	
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {
		
		try (Connection con = ConnectionProvider.getConnection()){
			
			PreparedStatement psmt = con.prepareStatement(INSERT);
			
			
			
			
		}
		
	}
	
	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {
		
		
	}
	
	@Override
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException, SQLException {
		
		
	}
	
	@Override
	public void selectById(Integer noUtilisateur) throws DALException, SQLException {
		
		
	}
	
	
	
}
