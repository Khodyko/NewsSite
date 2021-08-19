package controllerCommandMethods;

import java.io.IOException;

import bean.RegistrationInfo;
import bean.RoleEnum;
import bean.User;
import controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceException;
import service.ServiceProvider;
import service.UserService;

public class AuthorizationUser implements Command {
	private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
	private static final UserService USER_SERVICE = PROVIDER.getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path;
		String lastCommandName = "AUTHORIZATION_PAGE";
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		RoleEnum role = RoleEnum.STANDARD_USER;

		if (login == null || login.equals("") || password == null || password.equals("")) {
			path = "AUTHORIZATION_PAGE&message=Some of fields are empty, please fill it";
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
			return;
		}
		RegistrationInfo info = new RegistrationInfo(login, password, role);
		try {
			User user = USER_SERVICE.authorization(info);
			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("user", user);
				lastCommandName = "GO_TO_MAIN_PAGE";
				session.setAttribute("role", user.getRole().toString());
				session.setAttribute("lastURL", lastCommandName); // for redirect in localization
				response.sendRedirect("Controller?commandToController=" + lastCommandName);
			} else {
				throw new ServiceException("User is null");
			}
		} catch (ServiceException e) {
			request.setAttribute("message", "Login or password wrong");
			path = "AUTHORIZATION_PAGE&message=Registration complite, please log in";
			request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
		}
	}
}
