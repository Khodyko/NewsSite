package controllerCommandMethods;

import java.io.IOException;

import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GoToChangeNewsPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp/changeNewsPage.jsp";
		String lastCommandName="CHANGE_NEWS_PAGE";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
		requestDispatcher.forward(request, response);
	
	}

}
