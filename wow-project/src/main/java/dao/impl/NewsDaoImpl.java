package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.News;
import dao.DAOException;
import dao.NewsDao;
import dao.connectionpool.ConnectionPoolException;
import dao.connectionpool.NewsConnectionPool;

public class NewsDaoImpl implements NewsDao {
	private static final String PARAM_ID = "idnews";
	private static final String PARAM_TITLE = "title";
	private static final String PARAM_BRIEF = "brief_text";
	private static final String PARAM_FULL_TEXT = "full_text";
	private static final String PARAM_IMG_LINK = "img_link";
	private static final String SQL_INSERT_NEWS = "INSERT INTO news( " + PARAM_TITLE + ", " + PARAM_FULL_TEXT + ", "
			+ PARAM_BRIEF + ", " + PARAM_IMG_LINK + ") VALUES (?, ?, ?, ?)";
	private static final String SQL_GET_NUMBER_ROWS = "select count(*) from news";

	public void create(News entity) throws DAOException {

		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				PreparedStatement pr = connection.prepareStatement(SQL_INSERT_NEWS);) {

			pr.setString(1, entity.getTitle());
			pr.setString(2, entity.getFullText());
			pr.setString(3, entity.getBrief());
			pr.setString(4, entity.getImgLink());

			System.out.println("Remote DB connection established");
			pr.executeUpdate();

		} catch (SQLException e) {
			throw new DAOException("Remote server could not be connected", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("False query", e);
		} catch (Exception e) {

			throw new DAOException("False query", e);

		}
	}

	public List<News> getNewsList(String countOf5NewsPage) throws DAOException {
		String sql = "SELECT * FROM news";
		List<News> newsList = new ArrayList<News>();
		Integer id;
		String title;
		String fullText;
		String brief;
		String imgLink;

		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				Statement st = connection.createStatement();
				ResultSet result = st.executeQuery(sql);) {
			for (int i = 0; i < 5; i++) {
				if (!result.next()) {
					break;
				}
				id = result.getInt(PARAM_ID);
				title = result.getString(PARAM_TITLE);
				brief = result.getString(PARAM_BRIEF);
				fullText = result.getString(PARAM_FULL_TEXT);
				imgLink = result.getString(PARAM_IMG_LINK);
				newsList.add(new News(id, title, fullText, brief, imgLink));
			}
		} catch (SQLException e) {
			throw new DAOException("Remote server could not be connected", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("False query", e);
		} catch (Exception e) {
			throw new DAOException("False query", e);
		}

		return newsList;
	}

	public void update(News entity) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(News entity) throws DAOException {
		// TODO Auto-generated method stub

	}

	public String getNewsMaxNumber() throws DAOException {
		Integer numberRow = 0;
		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				PreparedStatement statement = connection.prepareStatement(SQL_GET_NUMBER_ROWS);
				ResultSet rs = statement.executeQuery();) {

						
			while (rs.next()) {
				numberRow = rs.getInt("count(*)");
			}
			
		} catch (SQLException e) {
			throw new DAOException("Remote server could not be connected", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("False query", e);
		} catch (Exception e) {
			throw new DAOException();
		}
		return numberRow.toString();
	}
}
