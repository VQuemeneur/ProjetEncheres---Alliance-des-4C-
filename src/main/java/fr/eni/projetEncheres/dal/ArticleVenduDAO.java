package fr.eni.projetEncheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.bo.ArticleVendu;
import fr.eni.projetEncheres.businessException.BusinessException;

public interface ArticleVenduDAO extends DAO<ArticleVendu> {

	public void insert(ArticleVendu articleVendu) throws BusinessException;

	public ArticleVendu selectById(int noArticle) throws BusinessException;

	public List<ArticleVendu> selectAll() throws BusinessException, SQLException;

	public void update(ArticleVendu articleVendu) throws BusinessException;

	public void delete(int noArticle) throws BusinessException;

	public List<ArticleVendu> selectByCategorie(int categorie) throws BusinessException, SQLException;

	public List<ArticleVendu> selectByFiltre(String filtre) throws BusinessException, SQLException;

}
