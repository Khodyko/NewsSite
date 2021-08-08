package dao;

import bean.RegistrationInfo;
import bean.User;
import dao.DAOException;

public interface UserDao {
	public void registration(RegistrationInfo info) throws DAOException;
	public boolean authorization(User entity) throws DAOException;
	public void updateLoginPassword(RegistrationInfo target, RegistrationInfo forChanging) throws DAOException;
	public void delete(RegistrationInfo entity) throws DAOException;
	

}
