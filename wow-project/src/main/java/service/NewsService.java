package service;

import java.util.ArrayList;
import java.util.List;

import bean.News;


public interface NewsService {
	void create(News news) throws ServiceException;

	void update(News news) throws ServiceException;
	
	List<News> getNewsList(Integer currentPageNumber) throws ServiceException;
	
	public Integer getNewsMaxNumber() throws ServiceException;
	
	

}
