package fr.eni.projetjee.TrocEncheres.dal;

public class EnchereDAOJdbcImpl {

	private static final String INSERT = "INSERT INTO enchere(no_enchere, date_enchere, montant_enchere) VALUES(?,?,?)";
	private static final String UPDATE = "UPDATE enchere SET date_enchere=?, montant_enchere=?WHERE no_enchere=?";
	private static final String DELETE= "DELETE FROM enchere WHERE no_enchere=?";
	private static final String SELECTALL= "SELECT * FROM enchere";
	private static final String SELECTBYID= "SELECT (no_enchere, date_enchere, montant_enchere) FROM enchere WHERE no_enchere=? )";

}
