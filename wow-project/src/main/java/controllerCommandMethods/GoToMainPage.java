package controllerCommandMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



import bean.News;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NewsService;
import service.ServiceProvider;

public class GoToMainPage implements Command {
		private static final ServiceProvider serviceProvider=ServiceProvider.getInstance();
		private static final NewsService newsService= serviceProvider.getNewService();
		String lastCommandName="GO_TO_MAIN_PAGE";
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
//		ArrayList<News> newses=new ArrayList<News>();
//		newses.add(new News("You will be shocked!", "In order to sit on a computer all day and get paid for it, you need...", "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		newses.add(new News("t2", "b2 b2 b2",  "resources/pictures/surpriseface.jpg"));
//		
//		request.setAttribute("newses", newses);
		
		
		String path = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
		request.getSession(true).setAttribute("lastURL", lastCommandName);  //for redirect in localization	
		requestDispatcher.forward(request, response);
	}

}
