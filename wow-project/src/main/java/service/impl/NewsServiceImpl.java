package service.impl;

import java.util.ArrayList;
import java.util.List;

import bean.News;
import dao.DAOException;
import dao.DaoProvider;
import dao.impl.NewsDaoImpl;
import service.NewsService;

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
	

}
