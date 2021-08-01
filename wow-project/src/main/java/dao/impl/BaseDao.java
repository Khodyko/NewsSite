package dao.impl;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

import bean.SqlSendable;
import dao.Dao;

public abstract class BaseDao<T extends SqlSendable> implements Dao<T> {
	public static Connection connection;
	
	
	 public static void connectionQuery()
	  {
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost/news_server","root","root");
//	            System.out.println("Remote DB connection established");
	        }
	        catch (ClassNotFoundException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote server could not be connected");
	        }
	        catch (NullPointerException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote server could not be connected");
	        }
	        catch (SQLException e)
	        {
	            e.printStackTrace();
	            System.out.println("Remote db connection establishment error");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	            System.out.println("False query");
	        }
	    }


	public BaseDao() {
		super();
		// TODO Auto-generated constructor stub
	}
}
