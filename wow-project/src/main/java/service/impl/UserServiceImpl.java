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
				throw new DAOException();// stub
			}
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	public User authorization(String login, String password) throws ServiceException {
//		try {
//			User user= new User();
//			USER_DAO_IMPL.create(null);
//				
//		} catch(DAOException e) {
//			throw new ServiceException(e);//????
//		}
		return new User();
//
	}

	private String validation(String string) {

		if (string.length() < 5) {
			return "Use at least 5 characters";
		} else {
			return "valid";
		}
	}

}
