package controllerCommandMethods;

import java.io.IOException;
import java.util.List;

import bean.News;
import controller.Command;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.NewsService;
import service.ServiceException;
import service.ServiceProvider;

public class DeleteNews implements Command {
	private static final ServiceProvider PROVIDER=ServiceProvider.getInstance();
	private static final NewsService NEWS_SERVICE = PROVIDER.getNewService();
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String lastCommandName="GO_TO_MAIN_PAGE";
		String path;
		News newsDelete = null;
		List<News> newsList=(List<News>) session.getAttribute("newses");
		String id=(String) request.getParameter("choosenNewsId");
		System.out.println("before cicle id= "+ id);
		for(int i=0 ; i<newsList.size(); i++) {
			System.out.println("delete id id acces id= "+id);
			System.out.println("delete id id acces Listid="+newsList.get(i).getId().toString());
			if(newsList.get(i).getId().toString().equals(id)) {
				newsDelete=newsList.get(i);
				System.out.println("delete id id acces id= "+id);
				break;
			}
		}
		try {
			NEWS_SERVICE.deleteNews(newsDelete);
			lastCommandName = "GO_TO_MAIN_PAGE";
			session.setAttribute("lastURL", lastCommandName); // for redirect in localization
			response.sendRedirect("Controller?commandToController=" + lastCommandName);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
