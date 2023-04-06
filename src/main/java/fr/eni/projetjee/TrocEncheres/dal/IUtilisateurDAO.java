package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.SQLException;
import java.util.List;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

public interface IUtilisateurDAO {
	
	public void insertUtilisateur(Utilisateur utilisateur ) throws DALException, SQLException;
	
	public void updateUtilisateur(Utilisateur utilisateur ) throws DALException, SQLException;
	
	public void deleteUtilisateur(Integer noUtilisateur ) throws DALException, SQLException;
	
	public List<Utilisateur> selectAllUtilisateurs () throws DALException, SQLException;
	
	public Utilisateur selectById(Integer noUtilisateur ) throws DALException, SQLException ;
	
	public Utilisateur selectByLogIn (String pseudo, String motDePasse) throws DALException, SQLException ;
	
	public Utilisateur selectByPseudo (String pseudo) throws DALException, SQLException ;
}
