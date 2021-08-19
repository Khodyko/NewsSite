package dao;

import bean.RegistrationInfo;
import bean.User;

public interface UserDao {
	public void registration(RegistrationInfo info) throws DAOException;

	User authorization(RegistrationInfo entity) throws DAOException;

	void updateLoginPassword(RegistrationInfo target, RegistrationInfo forChanging) throws DAOException;

	void delete(RegistrationInfo entity) throws DAOException;

}
