package dao;

import bean.News;
import bean.RegistrationInfo;
import bean.User;
import dao.impl.BaseDao;
import dao.impl.NewsDaoImpl;
import dao.impl.UserInfoDaoImpl;


public class DaoProvider {
	private static final DaoProvider instance = new DaoProvider();

//	private final UserDaoImpl userDao = new UserDaoImpl();
	private final NewsDaoImpl newDao = new NewsDaoImpl();
	
private final UserInfoDaoImpl registrationInfoDaoImpl=new UserInfoDaoImpl();

	public UserInfoDaoImpl getRegistrationInfoDaoImpl() {
	return registrationInfoDaoImpl;
}

	private DaoProvider() {}
	
	
	
	public static DaoProvider getInstance() {
		return instance;
	}


//	public UserDaoImpl getUserDao() {
//		return  userDao;
//	}


	public NewsDaoImpl getNewDao() {
		return  newDao;
	}
	


}
