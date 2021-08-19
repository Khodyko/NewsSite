package service.impl;

import dao.DAOException;

import dao.DaoProvider;
import dao.UserDao;
import dao.impl.UserDaoImpl;

import service.ServiceException;
import service.UserService;
import bean.RegistrationInfo;

import bean.User;

public class UserServiceImpl implements UserService {
	private static final DaoProvider DAO_PROVIDER = DaoProvider.getInstance();
	private static final UserDao USER_DAO_IMPL = DAO_PROVIDER.getRegistrationInfoDaoImpl();

	public void registration(RegistrationInfo info) throws ServiceException {
		try {
			if (validation(info.getLogin()).equals("valid") || info.getPassword().equals("valid")) {
				USER_DAO_IMPL.registration(info);
			} else {
				throw new ServiceException("Login or password is not valid"); //concrete
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	public User authorization(RegistrationInfo info) throws ServiceException {
		User user = null;
		try {
			if (validation(info.getLogin()).equals("valid") || info.getPassword().equals("valid")) {
				user = USER_DAO_IMPL.authorization(info);
			} else {
				throw new ServiceException("Login or password is not valid");//concrete
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	private String validation(String string) {
		if (string.length() < 5) {
			return "Use at least 5 characters";
		} else {
			return "valid";
		}
	}

}
