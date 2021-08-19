package dao;

import java.util.ArrayList;
import java.util.List;

import bean.News;

public interface NewsDao {
	public void create(News entity) throws DAOException;

	List<News> getNewsList(Integer countOf5NewsPage) throws DAOException;

	void update(News entity) throws DAOException;

	void delete(News entity) throws DAOException;

	Integer getNewsMaxId() throws DAOException;
}
