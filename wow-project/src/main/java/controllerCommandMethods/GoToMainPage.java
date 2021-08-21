package controllerCommandMethods;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bean.News;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.SessionCookieConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.NewsService;
import service.ServiceException;
import service.ServiceProvider;

public class GoToMainPage implements Command {
	private static final ServiceProvider PROVIDER = ServiceProvider.getInstance();
	private static final NewsService NEWS_SERVICE = PROVIDER.getNewService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/WEB-INF/jsp/main.jsp";
		String lastCommandName = "GO_TO_MAIN_PAGE";
		String currentPageNumber;
		String newsMaxNum = "1";
		Integer pagesMaxNum=1;
		List<String> numberOfPageList = null;
		HttpSession session = request.getSession(true);
		

		try {
			newsMaxNum = NEWS_SERVICE.getNewsMaxNumber();
			pagesMaxNum=Integer.parseInt(newsMaxNum)%5+Integer.parseInt(newsMaxNum)/5;

		} catch (ServiceException e) {
			path = "/WEB-INF/jsp/unknownPage.jsp";
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
			return;
		}
		
			numberOfPageList = new ArrayList<String>();
			for (Integer i = 1; i <= pagesMaxNum; i++) {
				numberOfPageList.add(i.toString());
			}
			
			Collections.sort(numberOfPageList);
			
			currentPageNumber = (String) session.getAttribute("currentPage");
			currentPageNumber = pageNumberValidation(currentPageNumber);
			if(!numberOfPageList.contains(currentPageNumber)) {
				currentPageNumber="1";
			}
			session.setAttribute("currentPage", currentPageNumber);
			session.setAttribute("pageNumList", numberOfPageList);
			

		try {
			List<News> newses = NEWS_SERVICE.getNewsList(currentPageNumber);
			session.setAttribute("newses", newses);
		} catch (ServiceException e) {
			path = "/WEB-INF/jsp/unknownPage.jsp";
			lastCommandName = "UNKNOWN_COMMAND";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + path);
			return;
		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		request.getSession(true).setAttribute("lastURL", lastCommandName); // for redirect in localization
		requestDispatcher.forward(request, response);
	}

	private String pageNumberValidation(String currentPageNumber) {

		if (currentPageNumber == null || currentPageNumber.equals("")) {
			currentPageNumber = "1";
		}
		try {
			Integer.parseInt(currentPageNumber);
		} catch (NumberFormatException e) {
			System.out.println("current Page Number is not a number");
			currentPageNumber = "1";
		}
		return currentPageNumber;
	}

}
