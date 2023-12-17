package fr.eni.projetEncheres.dal;

import java.util.List;

import fr.eni.projetEncheres.bo.Utilisateur;
import fr.eni.projetEncheres.businessException.BusinessException;

public interface UtilisateurDAO extends DAO<Utilisateur> {

	public void insert(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur selectById(int noUtilisateur) throws BusinessException;

	public List<Utilisateur> selectAll() throws BusinessException;

	public void update(Utilisateur utilisateur) throws BusinessException;

	public void delete(int noUtilisateur) throws BusinessException;

	public Utilisateur login(String pseudo, String motDePasse) throws BusinessException;

}
