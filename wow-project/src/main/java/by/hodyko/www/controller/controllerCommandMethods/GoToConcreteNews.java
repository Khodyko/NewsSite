package by.hodyko.www.controller.controllerCommandMethods;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.hodyko.www.bean.News;
import by.hodyko.www.controller.Command;
import by.hodyko.www.service.NewsService;
import by.hodyko.www.service.ServiceException;
import by.hodyko.www.service.ServiceProvider;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GoToConcreteNews implements Command {
	private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
	private static final NewsService NEWS_SERVICE = PROVIDER.getNewService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path = "/WEB-INF/jsp/concreteNews.jsp";

		HttpSession session = request.getSession(true);
		Integer choosenNewsId = Integer.parseInt(request.getParameter("choosenNewsId"));
		String lastCommandName = "GO_CONCRETE_NEWS&choosenNewsId=" + choosenNewsId;
		News choosenNews = null;
		Logger logger=LogManager.getLogger();

		if (choosenNewsId == null || choosenNewsId < 1) {
			path = "/WEB-INF/jsp/unknownPage.jsp";
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
			return;
		}

		try {
			choosenNews = NEWS_SERVICE.getNews(choosenNewsId);

		} catch (ServiceException e) {
			path = "/WEB-INF/jsp/unknownPage.jsp";
			logger.warn("lastcommand"+ lastCommandName+" "+e.getMessage());
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + lastCommandName);
			return;
		}

		if (choosenNews == null) {
			System.out.println("News is empty");
			path = "/WEB-INF/jsp/concreteNews.jsp";
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + lastCommandName);
			return;
		}

		lastCommandName = "GO_CONCRETE_NEWS&choosenNewsId=" + choosenNewsId;
		path = "/WEB-INF/jsp/concreteNews.jsp";
		request.setAttribute("choosenNews", choosenNews);
		session.setAttribute("lastURL", lastCommandName); // for redirect in localization
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
}
