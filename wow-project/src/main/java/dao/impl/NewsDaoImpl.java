package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import bean.News;
import bean.SqlSendable;
import dao.DAOException;

public class NewsDaoImpl extends BaseDao<News> {
	
	
	public void create(News entity) throws DAOException {
		
		try {
			connectionQuery();
			
			Statement statement =  connection.createStatement();
			statement.executeUpdate("INSERT news( title, full_text, brief_text, img_link) VALUES ('"+entity.getTitle()+"', '"+entity.getFullText()+"', '"+entity.getBrief()+"', '"+entity.getImgLink()+"')");
			System.out.println("PS has gone");	
			 connection.close();
		}	
		catch (Exception e) {
				throw new DAOException();
			}
	}

	
	public News read(News entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<News> getNewsList() throws DAOException{
		ArrayList<News> newsList=new ArrayList<News>();
		String title;
		String fullText;
		String brief;
		String imgLink;
		
		try {
			connectionQuery();
			PreparedStatement statement=connection.prepareStatement("SELECT * from news");
			ResultSet result=statement.executeQuery();
			while(result.next()) {
				title=result.getString("title");
				brief=result.getString("brief_text");
				fullText=result.getString("full_text");
				imgLink=result.getString("img_link");
				newsList.add(new News(title, fullText, brief, imgLink));
			}
		}catch (Exception e) {
			throw new DAOException();
		}
		
		
		return newsList;
	}

	
	public void update(News entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(News entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
		
	}


