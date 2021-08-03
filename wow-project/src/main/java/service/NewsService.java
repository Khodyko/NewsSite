package service;

import java.util.ArrayList;

import bean.News;


public interface NewsService {
	void add(News news) throws ServiceException;

	void update(News news) throws ServiceException;
	
	ArrayList<News> getNewsList(Integer countOf5NewsPage) throws ServiceException;

}
