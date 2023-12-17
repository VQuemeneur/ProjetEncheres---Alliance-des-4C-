package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

public class UtilisateurDAOjdbcImpl implements UtilisateurDAO {
	private static final String LOGIN = "select * from utilisateurs where (pseudo=? or email=?) and mot_de_passe=?";
	private static final String INSERT_UTILISATEUR = "insert into utilisateurs(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SELECTBYID = "select pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit, mot_de_passe from utilisateurs where no_utilisateur =?";
	private static final String UPDATE_UTILISATEUR = "update Utilisateurs set pseudo=?,nom=?,prenom=?,email=?,telephone=?,rue=?,code_postal=?,ville=?,mot_de_passe=? where no_utilisateur=?";
	private static final String DELETE_UTILISATEUR = "delete from utilisateurs where no_utilisateur=?";

	private static UtilisateurDAOjdbcImpl instance = null;

	// Ajout du constructeur

	public UtilisateurDAOjdbcImpl() {
	}

	public static UtilisateurDAOjdbcImpl getInstance() {
		if (instance == null) {
			instance = new UtilisateurDAOjdbcImpl();
		}
		return instance;
	}

	public Utilisateur login(String identifiant, String motDePasse) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(LOGIN);
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, motDePasse);
			ResultSet res = pstmt.executeQuery();

			if (res.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(res.getInt(1));
				utilisateur.setPseudo(res.getString(2));
				utilisateur.setNom(res.getString(3));
				utilisateur.setPrenom(res.getString(4));
				utilisateur.setEmail(res.getString(5));
				utilisateur.setTelephone(res.getString(6));
				utilisateur.setRue(res.getString(7));
				utilisateur.setCodePostal(res.getString(8));
				utilisateur.setVille(res.getString(9));
				utilisateur.setMotDePasse(res.getString(10));
				utilisateur.setCredit(res.getInt(11));

			}
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.LOGIN_ECHEC);
			throw businessException;
		}

		return utilisateur;

	}

	@Override
	public void insert(Utilisateur utilisateur) throws BusinessException {
		if (utilisateur == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				ResultSet rs;
				PreparedStatement pstmt;
				pstmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, utilisateur.getPseudo());
				pstmt.setString(2, utilisateur.getNom());
				pstmt.setString(3, utilisateur.getPrenom());
				pstmt.setString(4, utilisateur.getEmail());
				pstmt.setString(5, utilisateur.getTelephone());
				pstmt.setString(6, utilisateur.getRue());
				pstmt.setString(7, utilisateur.getCodePostal());
				pstmt.setString(8, utilisateur.getVille());
				pstmt.setString(9, utilisateur.getMotDePasse());
				pstmt.setInt(10, 0);
				pstmt.setByte(11, (byte) 0);
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					utilisateur.setNoUtilisateur(rs.getInt(1));
				}
				rs.close();
				pstmt.close();
				cnx.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_UTILISATEUR_ECHEC);
			throw businessException;
		}

	}

	@Override
	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			try {
				pstmt.setInt(1, noUtilisateur);
				ResultSet res = pstmt.executeQuery();
				if (res.next()) {
					utilisateur = new Utilisateur();
					utilisateur.setPseudo(res.getString("pseudo"));
					utilisateur.setNom(res.getString("nom"));
					utilisateur.setPrenom(res.getString("prenom"));
					utilisateur.setEmail(res.getString("email"));
					utilisateur.setTelephone(res.getString("telephone"));
					utilisateur.setRue(res.getString("rue"));
					utilisateur.setCodePostal(res.getString("code_postal"));
					utilisateur.setVille(res.getString("ville"));
					utilisateur.setCredit(res.getInt("credit"));
					utilisateur.setMotDePasse(res.getString("mot_de_passe"));
					utilisateur.setNoUtilisateur(noUtilisateur);
				}
				pstmt.close();
				cnx.close();

			} catch (SQLException e) {
				e.printStackTrace();
				cnx.rollback();
				throw e;
			}
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_PROFIL_ECHEC);
			throw businessException;
		}
		return utilisateur;
	}

	@Override
	public void update(Utilisateur utilisateur) throws BusinessException {
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
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
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Utilisateur> selectAll() throws BusinessException {
		return null;
	}

	@Override
	public void delete(int noUtilisateur) throws BusinessException {
		try {
			Connection cnx = ConnectionProvider.getConnection();

			PreparedStatement pstmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			pstmt.setInt(1, noUtilisateur);
			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
