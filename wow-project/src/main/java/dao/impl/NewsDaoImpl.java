package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.News;

import dao.DAOException;
import dao.NewsDao;
import dao.connectionpool.ConnectionPoolException;
import dao.connectionpool.DBNewsParameter;
import dao.connectionpool.DBNewsResourceManager;
import dao.connectionpool.NewsConnectionPool;

public class NewsDaoImpl implements NewsDao {
	private static final String SQL_INSERT_NEW= "INSERT INTO news( title, full_text, brief_text, img_link) VALUES (?, ?, ?, ?)";
	public void create(News entity) throws DAOException {



		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				PreparedStatement pr = connection.prepareStatement(SQL_INSERT_NEW);) {
			
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

	public ArrayList<News> getNewsList(Integer countOf5NewsPage) throws DAOException {
		String sql = "SELECT * FROM news";
		ArrayList<News> newsList = new ArrayList<News>();
		String title;
		String fullText;
		String brief;
		String imgLink;


		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				Statement st = connection.createStatement();
				ResultSet result = st.executeQuery(sql);) {
			while (result.next()) {
				title = result.getString("title");
				brief = result.getString("brief_text");
				fullText = result.getString("full_text");
				imgLink = result.getString("img_link");
				newsList.add(new News(title, fullText, brief, imgLink));
				System.out.println(title);
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

	public Integer getNewsMaxId() throws DAOException {
//		Integer numberRow=0;
//		try {
//			connectionQuery();
//			PreparedStatement statement=connection.prepareStatement("select count(*) from dataTable");
//			    ResultSet rs = statement.executeQuery();
//			    while(rs.next()){
//			        numberRow = rs.getInt("count(*)");
//			    }
//			System.out.println("PS has gone");	
//			 connection.close();
//		}	
//		catch (Exception e) {
//				throw new DAOException();
//			}
		return 0;
	}
}
