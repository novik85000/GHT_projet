package fr.eni.ghtprojet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.ghtprojet.bo.Retrait;
import fr.eni.ghtprojet.bo.Utilisateur;
import fr.eni.ghtprojet.utils.Connexion;

public class RetraitDAOImpl implements DAORetraits {
	
	private static final String SQL_SELECT_BY_ID = "select no_article, rue, code_postal "
			+ " from Retrait where no_ = ?";

	@Override
	public void insert(Retrait retrait) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Retrait selectById(int no_article) throws DALException {
		// mise en place de la connection 
		Connection connection = null;
		PreparedStatement stmt = null;
		System.out.println("connection a reussi");
		ResultSet rs = null;
		Retrait retrait = null;

					try {
						
						connection = Connexion.getConnection();
						stmt = connection.prepareStatement(SQL_SELECT_BY_ID );
							stmt.setInt(1, no_article);

							rs = stmt.executeQuery();
							if (rs.next()) {
								
						retrait = new Retrait(rs.getInt("no_article"), 
								rs.getString("rue"), 
								rs.getString("code_postal"),
								rs.getString("ville"));
						
							}
					} catch (SQLException e) {
						throw new DALException("selectById failed - NuméroUtilisateur = " + no_article, e);
					}
					return retrait;
			
			}

	@Override
	public List<Retrait> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Retrait retrait) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int no_article) {
		// TODO Auto-generated method stub

	}

}
