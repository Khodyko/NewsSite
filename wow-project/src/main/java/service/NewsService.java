package service;

import bean.News;


public interface NewsService {
	void add(News news) throws ServiceException;

	void update(News news) throws ServiceException;

}
