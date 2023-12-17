package fr.eni.projetEncheres.dal;

public abstract class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {

		return new UtilisateurDAOjdbcImpl();
	}

	public static ArticleVenduDAO getArticleVenduDAO() {

		return new ArticleVenduDAOjdbcImpl();
	}
}
