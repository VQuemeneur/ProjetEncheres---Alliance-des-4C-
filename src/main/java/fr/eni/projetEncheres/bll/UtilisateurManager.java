package fr.eni.projetEncheres.bll;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;
import fr.eni.projetEncheres.dal.DAOFactory;
import fr.eni.projetEncheres.dal.UtilisateurDAO;
import fr.eni.projetEncheres.dal.UtilisateurDAOjdbcImpl;

public class UtilisateurManager {
	private static UtilisateurManager instance = null;
	private UtilisateurDAO utilisateurDAO;

	private UtilisateurManager(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	// SINGLETON
	public static UtilisateurManager getInstance() {
		if (instance == null) {
			instance = new UtilisateurManager(UtilisateurDAOjdbcImpl.getInstance());
		}
		return instance;
	}

	public Utilisateur login(String pseudo, String motDePasse) throws BusinessException {
		return utilisateurDAO.login(pseudo, motDePasse);
	}

	// méthode pour insérer un nouvel utilisateur
	public void insert(Utilisateur u) throws BusinessException {
		u.setNom(u.getNom().toUpperCase());
		utilisateurDAO.insert(u);
	}

	// méthode pour retrouver le profil d'un utilisateur
	public Utilisateur selectById(int noUtilisateur) throws BusinessException {
		return utilisateurDAO.selectById(noUtilisateur);

	}

	// méthode pour mettre à jour un profil d'utilisateur
	public void update(Utilisateur u) throws BusinessException {
		utilisateurDAO.update(u);
	}

	// méthode pour supprimer un utilisateur
	public void delete(int noUtilisateur) throws BusinessException {
		utilisateurDAO.delete(noUtilisateur);
	}

}
