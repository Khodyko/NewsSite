package controllerCommandMethods;

import java.io.IOException;
import java.io.InputStream;
import bean.News;
import bean.User;
import controller.Command;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.ServiceProvider;
import service.NewsService;
import service.ServiceException;

public class AddNews implements Command {
	private static final ServiceProvider provider=ServiceProvider.getInstance();
	private static final NewsService newsService= provider.getNewService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String lastCommandName="ADD_NEWS_PAGE";
		String path;
		String title=request.getParameter("title");
		String fullText=request.getParameter("full_text");
		String brief=request.getParameter("brief");
		String imgLink=null;
		News news=new News(title, fullText, brief, imgLink);
		String message="News succesfully added";
		//		Part filePart = request.getPart("file");
//		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
//		InputStream fileContent = filePart.getInputStream(); //https://overcoder.net/q/1966/%D0%BA%D0%B0%D0%BA-%D0%B7%D0%B0%D0%B3%D1%80%D1%83%D0%B7%D0%B8%D1%82%D1%8C-%D1%84%D0%B0%D0%B9%D0%BB%D1%8B-%D0%BD%D0%B0-%D1%81%D0%B5%D1%80%D0%B2%D0%B5%D1%80-%D0%B8%D1%81%D0%BF%D0%BE%D0%BB%D1%8C%D0%B7%D1%83%D1%8F-jsp-servlet
		
//		if(session==null) {
//			lastCommandName="AUTHORIZATION_PAGE";
//			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
//			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in";
//			
//			response.sendRedirect(path);
//			return;
//		}
//		User user= (User)session.getAttribute("user");
//		if(user==null) {
//			
//			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Session is closed, please log in";
//			lastCommandName="AUTHORIZATION_PAGE";
//			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
//
//			request.getSession(true).setAttribute("lastURL", path ); //for redirect in localization
//			response.sendRedirect(path);
//			return;
//		}
//		if("admin".equals(user.getRole()) || "manager".equals(user.getRole()) ) {
//			session.removeAttribute("user");
//			//log
//			lastCommandName="AUTHORIZATION_PAGE";
//			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
//
//			path="Controller?commandToController=AUTHORIZATION_PAGE&message=Rights of User is exceeded. Session is closed, please log in";
//			response.sendRedirect(path);
//			return;
//		}
		try {
			if(news.getFullText()==null || news.getFullText().equals("")) {
				message="Field fullText is Empty";
				throw new ServiceException(message);
			}
			if(news.getTitle()==null || news.getTitle().equals("")){
				message="Field title is Empty";
				throw new ServiceException(message);
			}
			if(news.getBrief()==null || news.getBrief().equals("")) {
				if(news.getFullText().length()<41) {
					news.setBrief(news.getFullText());
				}
				else {
				news.setBrief(news.getFullText().substring(0,100)+"...");}
			}
			if(news.getImgLink()==null || news.getImgLink().equals("")) {
				news.setImgLink("resources/pictures/surpriseface.jpg");
			}
			newsService.add(news);
			request.setAttribute("message", message);
			path="ADD_NEWS_PAGE&message=Registration complite, please log in";
			request.getSession(true).setAttribute("lastURL", lastCommandName ); //for redirect in localization
//			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
//			requestDispatcher.forward(request, response);
			response.sendRedirect("Controller?commandToController="+path);
		}
		catch (ServiceException e) {
			path="ADD_NEWS_PAGE&message="+message;
			lastCommandName="REGISTRATION_PAGE";
			request.getSession(true).setAttribute("lastURL", lastCommandName); //for redirect in localization
			RequestDispatcher requestDispatcher=request.getRequestDispatcher(path);
			requestDispatcher.forward(request, response);
		}	
	}	
}
