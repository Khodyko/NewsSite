package service;

import service.impl.NewsServiceImpl;
import service.impl.UserServiceImpl;

public final class ServiceProvider {
	private static final ServiceProvider instance = new ServiceProvider();

	private final UserService userService = new UserServiceImpl();
	private final NewsService newService = new NewsServiceImpl();

	private ServiceProvider() {}
	
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public NewsService getNewService() {
		return newService;
	}

}
