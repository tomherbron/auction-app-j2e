package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import fr.eni.projetjee.TrocEncheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements IUtilisateurDAO {

	private static final String INSERT = "INSERT INTO utilisateur(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "UPDATE utilisateur SET pseudo=?, nom=?, prenom=?,email=?, telephone=?,rue=?,code_postal=?, ville=?,mot_de_passe=? WHERE no_utilisateur=?";
	private static final String DELETE = "DELETE FROM utilisateur WHERE no_utilisateur=?";
	private static final String SELECT_BY_ID = "SELECT (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit) FROM utilisateur WHERE no_utilisateur=? )";
	private static final String SELECT_BY_LOGIN = "SELECT `no_utilisateur`, `pseudo`, `nom`, `prenom`, `email`, `telephone`, `rue`, `code_postal`, `ville`, `mot_de_passe`, `credit`, `administrateur` FROM `utilisateur` WHERE pseudo=? AND mot_de_passe=?";
	private static final String SELECT_ALL = "SELECT `no_utilisateur`, `pseudo`, `nom`, `prenom`, `email`, `telephone`, `rue`, `code_postal`, `ville`, `mot_de_passe`, `credit`, `administrateur` FROM `utilisateur` ";
	private static final String SELECT_BY_PSEUDO = "SELECT (no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit) FROM utilisateur WHERE nom= ? ";
	@Override
	public void insertUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

					PreparedStatement pstmt = con.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
					pstmt.setString(1, utilisateur.getPseudo());
					pstmt.setString(2, utilisateur.getNom());
					pstmt.setString(3, utilisateur.getPrenom());
					pstmt.setString(4, utilisateur.getEmail());
					pstmt.setString(5, utilisateur.getTelephone());
					pstmt.setString(6, utilisateur.getRue());
					pstmt.setString(7, utilisateur.getCodePostal());
					pstmt.setString(8, utilisateur.getVille());
					pstmt.setString(9, utilisateur.getMotDePasse());
					pstmt.setInt(10, utilisateur.getCredit());
					pstmt.setBoolean(11, utilisateur.getAdministrateur());
					pstmt.executeUpdate();
					ResultSet rs = pstmt.getGeneratedKeys();
					if (rs.next()) {
						utilisateur.setNoUtilisateur(rs.getInt(1));
					}
					rs.close();
					pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Insert failed");
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws DALException, SQLException {

		try (Connection con = ConnectionProvider.getConnection()) {

			PreparedStatement pstmt = con.prepareStatement(UPDATE);

			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, utilisateur.getPseudo());
			pstmt.setString(2, utilisateur.getNom());
			pstmt.setString(3, utilisateur.getPrenom());
			pstmt.setString(4, utilisateur.getEmail());
			pstmt.setString(5, utilisateur.getTelephone());
			pstmt.setString(6, utilisateur.getRue());
			pstmt.setString(7, utilisateur.getCodePostal());
			pstmt.setString(8, utilisateur.getVille());
			pstmt.setString(9, utilisateur.getMotDePasse());
			pstmt.setInt(10, utilisateur.getNoUtilisateur());
			
			pstmt.executeUpdate();
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Update failed");
		}		
	}

	@Override
	public void deleteUtilisateur(Integer noUtilisateur) throws DALException, SQLException {
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, noUtilisateur);
			pstmt.executeUpdate();
			
			pstmt.close();
					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Delete failed");
		}		
		
	}

	@Override
	public Utilisateur selectById(Integer noUtilisateur) throws DALException, SQLException {
		Utilisateur utilisateur = null;
		try (Connection con = ConnectionProvider.getConnection()){
	
			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_ID);
			pstmt.setInt(1, noUtilisateur);
			ResultSet rs = pstmt.executeQuery();
	
			if(rs.next()){
				
				noUtilisateur = rs.getInt(1);
				String pseudo = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String email = rs.getString(5);
				String telephone = rs.getString(6);
				String rue = rs.getString(7);
				String codePostal = rs.getString(8);
				String ville = rs.getString(9);
				String motDePasse = rs.getString(10);
				Integer credit = rs.getInt(11);
				boolean administrateur = rs.getBoolean(12);
		
				utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email,telephone,rue, codePostal, ville, motDePasse, credit, administrateur);
				
			}
	
			pstmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("SelectById failed");
		}		
		
		return utilisateur;
		
	}

	@Override
	public Utilisateur selectByLogIn(String pseudo, String motDePasse) throws DALException, SQLException {
		
		Utilisateur utilisateur = null;
		
		try (Connection con = ConnectionProvider.getConnection()){
	
			PreparedStatement pstmt = con.prepareStatement(SELECT_BY_LOGIN);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, motDePasse);
			ResultSet rs = pstmt.executeQuery();
	
			if(rs.next()){
				
				Integer noUtilisateur = rs.getInt(1);
				pseudo = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String email = rs.getString(5);
				String telephone = rs.getString(6);
				String rue = rs.getString(7);
				String codePostal = rs.getString(8);
				String ville = rs.getString(9);
				motDePasse = rs.getString(10);
				Integer credit = rs.getInt(11);
				boolean administrateur = rs.getBoolean(12);
		
				utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email,telephone,rue, codePostal, ville, motDePasse, credit, administrateur);
				
			}
			
			pstmt.close();
			
		}	catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Erreur à la saisie du pseudo et/ou du mot de passe");
		}		
		
		return utilisateur;
		
	}

	@Override
	public List<Utilisateur> selectAllUtilisateurs() throws DALException, SQLException {
		List<Utilisateur> userList = new ArrayList<>();
        Utilisateur utilisateur = null;

        try (Connection con = ConnectionProvider.getConnection()){

            PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
            	Integer noUtilisateur = rs.getInt(1);
				String pseudo = rs.getString(2);
				String nom = rs.getString(3);
				String prenom = rs.getString(4);
				String email = rs.getString(5);
				String telephone = rs.getString(6);
				String rue = rs.getString(7);
				String codePostal = rs.getString(8);
				String ville = rs.getString(9);
				String motDePasse = rs.getString(10);
				Integer credit = rs.getInt(11);
				boolean administrateur = rs.getBoolean(12);

				utilisateur = new Utilisateur (noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit, administrateur);
				userList.add(utilisateur);
				
            }
            
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new DALException("SelectAll failed");
        }

        return userList;
		
	}
	


public Utilisateur selectByPseudo(String pseudo) throws DALException, SQLException {
	Utilisateur utilisateur = null;
	try (Connection con = ConnectionProvider.getConnection()){

		PreparedStatement pstmt = con.prepareStatement(SELECT_BY_PSEUDO);
		pstmt.setString(1, pseudo);
		ResultSet rs = pstmt.executeQuery();

		if(rs.next()){
			
			Integer noUtilisateur = rs.getInt(1);
			pseudo = rs.getString(2);
			String nom = rs.getString(3);
			String prenom = rs.getString(4);
			String email = rs.getString(5);
			String telephone = rs.getString(6);
			String rue = rs.getString(7);
			String codePostal = rs.getString(8);
			String ville = rs.getString(9);
			String motDePasse = rs.getString(10);
			Integer credit = rs.getInt(11);
			boolean administrateur = rs.getBoolean(12);
	
			utilisateur = new Utilisateur(noUtilisateur, pseudo, nom, prenom, email,telephone,rue, codePostal, ville, motDePasse, credit, administrateur);
			
		}

		pstmt.close();
	
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DALException("SelectById failed");
	}		
	
	return utilisateur;
	
}

}

