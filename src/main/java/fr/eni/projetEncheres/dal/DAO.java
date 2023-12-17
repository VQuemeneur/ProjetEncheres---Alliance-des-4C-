package fr.eni.projetEncheres.dal;

import java.sql.SQLException;
import java.util.List;

import fr.eni.projetEncheres.businessException.BusinessException;

public interface DAO<T> {

	public List<T> selectAll() throws BusinessException, SQLException;

	public void insert(T data) throws BusinessException;

	public T selectById(int id) throws BusinessException;

	public void update(T data) throws BusinessException;

	public void delete(int id) throws BusinessException;

}
