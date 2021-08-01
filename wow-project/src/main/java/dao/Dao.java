package dao;

import bean.SqlSendable;

public interface Dao <T extends SqlSendable> {
	  Long create(T entity) throws DAOException;

	    T read(T entity) throws DAOException;

	    void update(T entity) throws DAOException;
	    void delete(T entity) throws DAOException;
	    
	    
}
