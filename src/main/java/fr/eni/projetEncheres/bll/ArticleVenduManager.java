package fr.eni.projetEncheres.bll;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.businessException.BusinessException;
import fr.eni.projetEncheres.dal.ArticleVenduDAO;
import fr.eni.projetEncheres.dal.ArticleVenduDAOjdbcImpl;
import fr.eni.projetEncheres.dal.DAOFactory;

public class ArticleVenduManager {
	private static ArticleVenduManager instance = null;
	private ArticleVenduDAO articleVenduDAO;

	private ArticleVenduManager(ArticleVenduDAO articleVenduDAO) {
		this.articleVenduDAO = DAOFactory.getArticleVenduDAO();
	}

	// SINGLETON
	public static ArticleVenduManager getInstance() {
		if (instance == null) {
			instance = new ArticleVenduManager(ArticleVenduDAOjdbcImpl.getInstance());
		}
		return instance;
	}

	// méthode pour insérer un nouvel articles
	public void insert(ArticleVendu a) throws BusinessException {
		a.setNomArticle(a.getNomArticle().toUpperCase());
		articleVenduDAO.insert(a);
	}

	// méthode pour retrouver le profil d'un articles
	public ArticleVendu selectById(int noArticle) throws BusinessException {
		return articleVenduDAO.selectById(noArticle);
	}

	// méthode pour mettre à jour un profil d'articles
	public void update(ArticleVendu a) throws BusinessException {
		articleVenduDAO.update(a);
	}

	// méthode pour lister tous les articles en vente
	public List<ArticleVendu> selectAll() throws SQLException, BusinessException {
		return articleVenduDAO.selectAll();
	}

	public List<ArticleVendu> selectByCategorie(int categorie) throws BusinessException, SQLException {
		return articleVenduDAO.selectByCategorie(categorie);
	}

	public List<ArticleVendu> selectByFiltre(String filtre) throws BusinessException, SQLException {
		return articleVenduDAO.selectByFiltre(filtre);
	}

}
