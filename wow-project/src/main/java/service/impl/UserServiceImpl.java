package service.impl;

import dao.DAOException;
import service.ServiceException;
import service.UserService;
import bean.RegistrationInfo;
import bean.User;




public class UserServiceImpl implements UserService {

	
	public void registration(RegistrationInfo info) throws ServiceException {
		
		try {
			if(!validation(info.getLogin()).equals("valid") || !info.getPassword().equals("valid")) {
				throw new ServiceException();
			}
			
		    throw new DAOException();//stub	
			
		}catch(DAOException e) {
			throw new ServiceException(e);
		}
		
	}
	public User authorization(String login, String password) throws ServiceException{
//		try {
//			 throw new DAOException();//stub	
//				
//		} catch(DAOException e) {
//			throw new ServiceException(e);//????
//		}
		return new User();
	
	}
	
	private String validation(String string) {
		
		if(string==null || string.length()<5) {
			return "Use at least 5 characters";
			}
		else {
			return "valid";
		}
	}

}
