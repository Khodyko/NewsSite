package dao;

import java.util.ArrayList;

import bean.News;

public interface NewsDao {
	public void create(News entity) throws DAOException;
	public ArrayList<News> getNewsList(Integer countOf5NewsPage) throws DAOException;
	public void update(News entity) throws DAOException;
	public void delete(News entity) throws DAOException;
	public Integer getNewsMaxId() throws DAOException;
}
