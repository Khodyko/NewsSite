package controllerCommandMethods;

import java.io.IOException;

import bean.RegistrationInfo;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

public class RegistrationNewUser implements Command {
	private static final ServiceProvider provider=ServiceProvider.getInstance();
	private static final UserService userService= provider.getUserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login=request.getParameter("login");
		String password=request.getParameter("password");
		RegistrationInfo info = new RegistrationInfo(login, password);
		try {
			userService.registration(info);
			request.setAttribute("message", "Registration complite, please log in");
			response.sendRedirect("Controller?commandToController=AUTHORIZATION_PAGE&message=Registration complite, please log in");
		}
		catch (ServiceException e) {
			response.sendRedirect("Controller?commandToController=REGISTRATION_PAGE&message=Registration not complite");
			
			
			
		}
		
		
		
		
		
	}

}
