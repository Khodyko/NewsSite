package controllerCommandMethods;

import java.io.IOException;

import bean.RegistrationInfo;
import bean.RoleEn;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

public class RegistrationNewUser implements Command {
	private static final ServiceProvider provider = ServiceProvider.getInstance();
	private static final UserService userService = provider.getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path;
		String lastCommandName = "AUTHORIZATION_PAGE";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		RoleEn role = RoleEn.STANDARD_USER;

		if (login == null || login.equals("") || password == null || password.equals("")) {
			path = "REGISTRATION_PAGE&message=Some of fields are empty, please fill it";
			lastCommandName = "REGISTRATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
			return;
		}

		RegistrationInfo info = new RegistrationInfo(login, password, role);

		try {
			userService.registration(info);
			request.setAttribute("message", "Registration complite, please log in");
			path = "AUTHORIZATION_PAGE&message=Registration complite, please log in";
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
		} catch (ServiceException e) {
			e.printStackTrace();//log
			path = "REGISTRATION_PAGE&message=Registration not complite";
			lastCommandName = "REGISTRATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);

		}
	}
}
