package service;

import bean.RegistrationInfo;
import bean.User;

public interface UserService {
	
	void registration(RegistrationInfo info) throws ServiceException; 
	User authorization(String login, String password) throws ServiceException; 
}
