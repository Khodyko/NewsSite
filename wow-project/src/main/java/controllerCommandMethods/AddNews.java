package controllerCommandMethods;

import java.io.IOException;

import bean.User;
import controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ServiceProvider;
import service.NewsService;

public class AddNews implements Command {
	private static final ServiceProvider provider=ServiceProvider.getInstance();
	private static final NewsService newsService= provider.getNewService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null) {
			response.sendRedirect("Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in");
			return;
		}
		User user= (User)session.getAttribute("user");
		if(user==null) {
			response.sendRedirect("Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in");
			return;
		}
		if("admin".equals(user.getRole())) {
			session.removeAttribute("user");
			//log
			// redirect
			response.sendRedirect("Controller?commandToController=AUTHORIZATION_PAGE&message=Rights of User is exceeded. Session is closed, please log in");
			return;
		}
		
		
	}

	
	
}
