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
		String lastCommandName="GO_TO_MAIN_PAGE";
		String path;
		if(session==null) {
			lastCommandName="AUTHORIZATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in";
			
			response.sendRedirect(path);
			return;
		}
		User user= (User)session.getAttribute("user");
		if(user==null) {
			
			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in";
			lastCommandName="AUTHORIZATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization

			request.getSession(true).setAttribute("lastURL", path ); //for redirect in localization
			response.sendRedirect(path);
			return;
		}
		if("admin".equals(user.getRole())) {
			session.removeAttribute("user");
			//log
			lastCommandName="AUTHORIZATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization

			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Rights of User is exceeded. Session is closed, please log in";
			response.sendRedirect(path);
			return;
		}
		
		//where are we go?
	}

	
	
}
