package controllerCommandMethods;

import java.io.IOException;
import java.util.List;

import bean.News;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToConcreteNews implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/jsp/concreteNews.jsp";
		String lastCommandName = "GO_CONCRETE_NEWS";
		HttpSession session = request.getSession(true);
		String choosenNewsId = request.getParameter("choosenNewsId"); 
		News choosenNews = null;
		
		List<News> newsList = (List)session.getAttribute("newses");
		if (newsList != null ) {
			
		for (int i = 0; i < newsList.size(); i++) {
			if (newsList.get(i).getId().toString().equals(choosenNewsId)) {
				choosenNews = newsList.get(i);
			}
		}}
		if (choosenNews == null) {
			System.out.println("News is empty");
			path = "/WEB-INF/jsp/concreteNews.jsp";
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + lastCommandName);
			return;
		}
		path = "/WEB-INF/jsp/concreteNews.jsp";
		session.setAttribute("lastViewedNews", choosenNews);
		session.setAttribute("lastURL", lastCommandName); // for redirect in localization
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
		}
}
