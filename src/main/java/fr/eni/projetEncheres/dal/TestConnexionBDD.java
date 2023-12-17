package fr.eni.projetEncheres.dal;



import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

public class TestConnexionBDD {

	public static void main(String[] args) {

		// Déclaration et instanciation de la DAO
		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		
		// Sélection d'un utilisateur par id
		Utilisateur u = null;
		try {
			u = utilisateurDAO.selectById(3);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sélection de l'article par id  : " + u.toString());
		
	}
}
