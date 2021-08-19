package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.relation.Role;
import dao.connectionpool.ConnectionPoolException;

import bean.News;
import bean.RegistrationInfo;
import bean.RoleEnum;
import bean.User;
import dao.DAOException;
import dao.UserDao;
import dao.connectionpool.ConnectionPoolException;
import dao.connectionpool.DBNewsParameter;
import dao.connectionpool.DBNewsResourceManager;
import dao.connectionpool.NewsConnectionPool;

public class UserDaoImpl implements UserDao {
	private static final DBNewsResourceManager DB_NEWS_RES_MAN = DBNewsResourceManager.getInstance();

	public void registration(RegistrationInfo entity) throws DAOException {
		String sql = "INSERT INTO users(user_name, password, role) VALUES ('" + entity.getLogin() + "', '"
				+ entity.getPassword() + "', '" + entity.getRole().toString() + "')";
		try {
			Class.forName(DB_NEWS_RES_MAN.getValue(DBNewsParameter.DB_NEWS_DRIVER));
		} catch (ClassNotFoundException e) {
			throw new DAOException("Class of connection is not found", e);
		}

		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				PreparedStatement pr = connection.prepareStatement(sql);) {

			System.out.println("Remote DB connection established");
			pr.executeUpdate();
		} catch (NullPointerException e) {
			throw new DAOException("Remote server could not be connected NullPointerException", e);
		} catch (SQLException e) {
			throw new DAOException("Remote server could not be connected SQLException", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("False query", e);
		} catch (Exception e) {
			throw new DAOException("False query", e);
		}
	}

	public User authorization(RegistrationInfo entity) throws DAOException {
		// we don't check the role!!! we only get it here!
		User sqlUser;
		String sql = "SELECT * from users WHERE(user_name= '" + entity.getLogin() + "' AND password= '"
				+ entity.getPassword() + "')";
		try {
			Class.forName(DB_NEWS_RES_MAN.getValue(DBNewsParameter.DB_NEWS_DRIVER));
		} catch (ClassNotFoundException e) {
			throw new DAOException("Class of connection is not found", e);
		}

		try (Connection connection = NewsConnectionPool.getInstance().takeConnection();
				PreparedStatement pr = connection.prepareStatement(sql);) {

			System.out.println("Remote DB connection established");
			ResultSet result = pr.executeQuery();
			if (!result.next()) {
				sqlUser = null;

			} else {
				String login = result.getString("user_name");
				String roleString = result.getString("role");
				try {
					RoleEnum roleRole = RoleEnum.valueOf(roleString);
					sqlUser = new User(login, roleRole);
				} catch (IllegalArgumentException e) {
					throw new DAOException("Role of DB is not contains in RoleEnum", e);
				}
			}
			return sqlUser;
		} catch (NullPointerException e) {
			throw new DAOException("Remote server could not be connected NullPointerException", e);
		} catch (SQLException e) {
			throw new DAOException("Remote server could not be connected SQLException", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("False query", e);
		} catch (Exception e) {
			throw new DAOException("False query", e);
		}

	}

	public void updateLoginPassword(RegistrationInfo target, RegistrationInfo forChanging) throws DAOException {
		// TODO Auto-generated method stub

	}

	public void delete(RegistrationInfo entity) throws DAOException {
		// TODO Auto-generated method stub

	}

}
