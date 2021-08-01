package dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.table.TableStringConverter;



public class DBHelper  {
//	 public static Connection con;
//	  public SortedMap<Long, String> createEntry(String tableName) throws DAOException  {
//	      try{
//	    	  connectionQuery();
//	            PreparedStatement statement =  con.prepareStatement("SELECT * from"+tableName);/*write query inside of prepared statement*/
//	            ResultSet result = statement.executeQuery();
////	            System.out.println("DataBase table accessed");
//	            SortedMap<Long, String> scoreMap=new TreeMap<Long, String>();
//	            while(result.next())
//	            {
//	               String name= result.getString("Name");
//	               Long score=Long.parseLong(result.getString("Score"));
//	               scoreMap.put(score, name);	               
//	            }
//	            con.close();
//	            return scoreMap;	          
//	        }
//	        catch(Exception e)
//	        {
//	            throw new DAOException();
//	           
//	        }
////		return null;
//	  }
//	  public void registerUser(String login, Long scoreTime) {
//		  try
//	        {
//	            connectionQuery();
//
//	            java.sql.Statement statement =  con.createStatement();
//	            statement.executeUpdate("INSERT score(Name, Score) VALUES ('"+login+"', "+scoreTime+")");
//	           
//	            con.close();}
//		  catch(Exception e)
//	        {
////	            throw new DAOException();
//	           
//	        }
//	  }
//	  
	  
	 
	}
