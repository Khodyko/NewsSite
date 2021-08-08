package service;

import bean.RegistrationInfo;
import bean.User;

public interface UserService {
	
	void registration(RegistrationInfo info) throws ServiceException; 
	User authorization(RegistrationInfo info) throws ServiceException; 
}
