package fr.eni.projetjee.TrocEncheres.dal;
import java.sql.SQLException;
import fr.eni.projetjee.TrocEncheres.bo.Retrait;

public interface IRetraitDAO {
	
	public void updateRetrait(Retrait retrait) throws DALException, SQLException  ;
	
	public void selectRetrait(Integer noArticle) throws DALException, SQLException  ;
	
}
