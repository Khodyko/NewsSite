package controllerCommandMethods;

import java.io.IOException;

import bean.User;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

public class AuthorizationUser implements Command {
	private static final ServiceProvider provider=ServiceProvider.getInstance();
	private static final UserService userService= provider.getUserService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path;
		String lastCommandName="GO_TO_MAIN_PAGE";
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		try {
		User user=	userService.authorization(login, password);
		HttpSession session=request.getSession(true); 
		session.setAttribute("user", user);
		
		} catch (ServiceException e) {
			request.setAttribute("message", "Login or password wrong");
			path="AUTHORIZATION_PAGE&message=Registration complite, please log in";
			lastCommandName="AUTHORIZATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
			response.sendRedirect("Controller?commandToController="+path);
		}
	
		request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
		response.sendRedirect("Controller?commandToController="+lastCommandName);
		
		
	}

}
