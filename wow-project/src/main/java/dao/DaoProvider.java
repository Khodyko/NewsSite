package dao;


import dao.impl.NewsDaoImpl;
import dao.impl.UserDaoImpl;

public class DaoProvider {
	private static final DaoProvider INSTANCE = new DaoProvider();

	private final UserDao userDao = new UserDaoImpl();
	private final NewsDao newDao = new NewsDaoImpl();

	private final UserDaoImpl registrationInfoDaoImpl = new UserDaoImpl();

	public UserDaoImpl getRegistrationInfoDaoImpl() {
		return registrationInfoDaoImpl;
	}

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return INSTANCE;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public NewsDao getNewDao() {
		return newDao;
	}

}
