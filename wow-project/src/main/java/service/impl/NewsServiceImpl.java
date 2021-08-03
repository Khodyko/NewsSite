package service.impl;

import java.util.ArrayList;
import java.util.List;

import bean.News;
import dao.DAOException;
import dao.DaoProvider;
import dao.impl.NewsDaoImpl;
import service.NewsService;
import service.ServiceException;

public class NewsServiceImpl implements NewsService {
	private static final DaoProvider DAO_PROVIDER = DaoProvider.getInstance();
	private static final NewsDaoImpl NEWS_DAO_IMPL=DAO_PROVIDER.getNewDao();
	
	@Override
	public void add(News news) {
		try {
				NEWS_DAO_IMPL.create(news);
		} catch (DAOException e) {
//			throw new ServiceException(e);
		}
	}



	@Override
	public void update(News news) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public ArrayList<News> getNewsList(Integer countOf5NewsPage) throws ServiceException {
		ArrayList<News> newsList=new ArrayList<News>();
		try {
			newsList=NEWS_DAO_IMPL.getNewsList(countOf5NewsPage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return newsList;
	}
	
	
	

}
