package controllerCommandMethods;

import java.io.IOException;

import bean.RegistrationInfo;
import bean.RoleEnum;
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
	private static final ServiceProvider provider = ServiceProvider.getInstance();
	private static final UserService userService = provider.getUserService();

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
			User user = userService.authorization(info);
			if (user != null) {
				System.out.println(user.getRole().toString()+" it is works!!!!!!!!!!!");
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
