package fr.eni.projetEncheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

public class ArticleVenduDAOjdbcImpl implements ArticleVenduDAO {

	private static final String INSERT_ARTICLEVENDU = "insert into articles_vendus(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) values(?,?,?,?,?,?,?,?)";
	private static final String LISTE_ENCHERES = "SELECT a.nom_article, a.prix_vente, a.date_fin_encheres, a.no_utilisateur, u.pseudo, a.no_article, a.no_categorie, a.description, a.prix_initial FROM articles_vendus a JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur";
	private static final String LISTE_ENCHERES_CATEGORIE = "SELECT a.nom_article, a.prix_vente, a.date_fin_encheres, a.no_utilisateur, u.pseudo FROM articles_vendus a JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur WHERE no_categorie =?";
	private static final String LISTE_ENCHERES_FILTRE = "SELECT a.nom_article, a.prix_vente, a.date_fin_encheres, a.no_utilisateur, u.pseudo FROM articles_vendus a JOIN utilisateurs u ON a.no_utilisateur = u.no_utilisateur WHERE nom_article LIKE ?";
	private static final String SELECTBYID = "select nom_article, description, date_fin_encheres, prix_initial, prix_vente,  no_categorie, no_article FROM articles_vendus where no_article=?";
	private static ArticleVenduDAOjdbcImpl instance = null;

	public ArticleVenduDAOjdbcImpl() {
	}

	public static ArticleVenduDAOjdbcImpl getInstance() {
		if (instance == null) {
			instance = new ArticleVenduDAOjdbcImpl();
		}
		return instance;
	}

	public void insert(ArticleVendu articleVendu) throws BusinessException {
		if (articleVendu == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLEVENDU_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				cnx.setAutoCommit(false);
				ResultSet rs;
				PreparedStatement pstmt;
				pstmt = cnx.prepareStatement(INSERT_ARTICLEVENDU, PreparedStatement.RETURN_GENERATED_KEYS);
				pstmt.setString(1, articleVendu.getNomArticle());
				pstmt.setString(2, articleVendu.getDescription());
				pstmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
				pstmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
				pstmt.setInt(5, articleVendu.getMiseAPrix());
				pstmt.setInt(6, articleVendu.getMiseAPrix());
				pstmt.setInt(7, articleVendu.getVendeur());
				pstmt.setInt(8, articleVendu.getCategorie());
				pstmt.executeUpdate();
				rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendu.setNoArticle(rs.getInt(1));
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
			businessException.ajouterErreur(CodesResultatDAL.INSERT_ARTICLEVENDU_ECHEC);
			throw businessException;
		}
	}

	@Override
	public ArticleVendu selectById(int noArticle) throws BusinessException {
		ArticleVendu article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmt = cnx.prepareStatement(SELECTBYID);
			try {
				pstmt.setInt(1, noArticle);
				ResultSet res = pstmt.executeQuery();
				if (res.next()) {
					article = new ArticleVendu();
					article.setNomArticle(res.getString("nom_article"));
					article.setDescription(res.getString("description"));
					article.setCategorie(res.getInt("no_categorie"));
					article.setPrixVente(res.getInt("prix_vente"));
					article.setMiseAPrix(res.getInt("prix_initial"));
					article.setDateFinEncheres(res.getDate("date_fin_encheres").toLocalDate());
					article.setNoArticle(res.getInt("no_article"));
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
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_ECHEC);
			throw businessException;
		}
		return article;
	}

	@Override
	public List<ArticleVendu> selectAll() throws BusinessException, SQLException {
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement pstmt = cnx.prepareStatement(LISTE_ENCHERES);
				ResultSet res = pstmt.executeQuery();
				while (res.next()) {
					ArticleVendu a = new ArticleVendu();
					a.setNomArticle(res.getString("nom_article"));
					a.setPrixVente(res.getInt("prix_vente"));
					a.setDateFinEncheres(res.getDate("date_fin_encheres").toLocalDate());
					a.setNoUtilisateur(res.getInt("no_utilisateur"));
					a.setVendeur(res.getInt("no_utilisateur"));
					a.setNoArticle(res.getInt("no_article"));
					a.setCategorie(res.getInt("no_categorie"));
					a.setDescription(res.getString("description"));
					a.setMiseAPrix(res.getInt("prix_initial"));

					articles.add(a);
				}
				pstmt.close();
				cnx.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return articles;
	}

	@Override
	public List<ArticleVendu> selectByCategorie(int categorie) throws BusinessException, SQLException {
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				PreparedStatement pstmt = cnx.prepareStatement(LISTE_ENCHERES_CATEGORIE);
				pstmt.setInt(1, categorie);
				ResultSet res = pstmt.executeQuery();
				while (res.next()) {
					ArticleVendu a = new ArticleVendu();
					a.setNomArticle(res.getString("nom_article"));
					a.setPrixVente(res.getInt("prix_vente"));
					a.setDateFinEncheres(res.getDate("date_fin_encheres").toLocalDate());
					a.setNoUtilisateur(res.getInt("no_utilisateur"));
					a.setVendeur(res.getInt("no_utilisateur"));

					articles.add(a);
				}
				pstmt.close();
				cnx.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return articles;

	}

	@Override
	public List<ArticleVendu> selectByFiltre(String filtre) throws BusinessException, SQLException {
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection()) {
			try {
				filtre = "%" + filtre + "%";
				PreparedStatement pstmt = cnx.prepareStatement(LISTE_ENCHERES_FILTRE);
				pstmt.setString(1, filtre);
				ResultSet res = pstmt.executeQuery();
				while (res.next()) {
					ArticleVendu a = new ArticleVendu();
					a.setNomArticle(res.getString("nom_article"));
					a.setPrixVente(res.getInt("prix_vente"));
					a.setDateFinEncheres(res.getDate("date_fin_encheres").toLocalDate());
					a.setNoUtilisateur(res.getInt("no_utilisateur"));
					a.setVendeur(res.getInt("no_utilisateur"));

					articles.add(a);
				}
				pstmt.close();
				cnx.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return articles;
	}

	@Override
	public void update(ArticleVendu articleVendu) throws BusinessException {
	}

	@Override
	public void delete(int noArticle) throws BusinessException {
	}

}
