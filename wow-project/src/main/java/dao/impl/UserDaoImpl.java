package dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.relation.Role;
import dao.connectionpool.ConnectionPoolException;

import bean.News;
import bean.RegistrationInfo;
import bean.User;
import dao.DAOException;
import dao.UserDao;
import dao.connectionpool.ConnectionPoolException;
import dao.connectionpool.DBNewsParameter;
import dao.connectionpool.DBNewsResourceManager;
import dao.connectionpool.NewsConnectionPool;

public class UserDaoImpl implements UserDao{
	private static final DBNewsResourceManager DB_NEWS_RES_MAN = DBNewsResourceManager.getInstance();

	
	public void registration(RegistrationInfo entity) throws DAOException {
		String sql="INSERT INTO users(user_name, password, role) VALUES ('"+entity.getLogin()+"', '"+entity.getPassword()+"', '"+entity.getRole().toString()+"')";
		 try {
				Class.forName(DB_NEWS_RES_MAN.getValue(DBNewsParameter.DB_NEWS_DRIVER));
			} catch (ClassNotFoundException e) {
				 throw new DAOException("Class of connection is not found", e);
			}
		 
		 try(Connection connection = NewsConnectionPool.getInstance().takeConnection();
					PreparedStatement pr = connection.prepareStatement(sql);){
			 
	            System.out.println("Remote DB connection established");
	            pr.executeUpdate();
	        }
	        catch (NullPointerException e)
	        {
	        	throw new DAOException("Remote server could not be connected1", e);
	        }
	        catch (SQLException e)
	        {
	        	throw new DAOException("Remote server could not be connected2", e);
	        }
		 	catch (ConnectionPoolException e) {
		 		throw new DAOException("False query", e);  
			}
	        catch (Exception e)
	        {
	        	throw new DAOException("False query", e);  
	        }  	
	}	
		
		public boolean authorization(User entity) throws DAOException{
			
//			String queryString="";
//			try {
//				PreparedStatement statement=connection.prepareStatement(queryString);
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return true;
		}


		public void updateLoginPassword(RegistrationInfo target, RegistrationInfo forChanging) throws DAOException {
			// TODO Auto-generated method stub
			
		}


		public void delete(RegistrationInfo entity) throws DAOException {
			// TODO Auto-generated method stub
			
		}

		
	}

