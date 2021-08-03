package dao.impl;


import java.sql.Statement;

import javax.management.relation.Role;

import bean.News;
import bean.RegistrationInfo;
import dao.DAOException;

public class RegistrationInfoDaoImpl extends BaseDao<RegistrationInfo> {

	
	public void create(RegistrationInfo entity) throws DAOException {
		if(entity==null) {
			throw new DAOException();//stub
		}
		else if(entity.getLogin()==null ) {
			throw new DAOException();//stub
		}
		else if(entity.getPassword()==null){
			throw new DAOException();//stub
		}
		try {
			connectionQuery();
			
//			PreparedStatement preparedStatement=connection.prepareStatement("INSERT user(user_name, password, role) VALUES ('"+entity.getLogin()+"', '"+entity.getPassword()+"', '"+entity.getRole().toString()+"')");
			Statement statement =  connection.createStatement();
			statement.executeUpdate("INSERT users(user_name, password, role) VALUES ('"+entity.getLogin()+"', '"+entity.getPassword()+"', '"+entity.getRole()+"')");
			System.out.println("PS has gone");	
			 connection.close();
		}
			
		catch (Exception e) {
				throw new DAOException();
			}
	}

	
	public RegistrationInfo read(RegistrationInfo entity) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void update(RegistrationInfo entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(RegistrationInfo entity) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	public RegistrationInfoDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
