package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.SystemException;
import model.AccountDetailsPojo;
import model.UsersPojo;

public class UsersDaoDatabaseImpl implements UsersDao {

	@Override
	public UsersPojo addUser(UsersPojo usersPojo, AccountDetailsPojo accountDetailsPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query1 = "INSERT INTO users(username, password) VALUES ('"+usersPojo.getUsername()+"', '"+usersPojo.getPassword()+"') returning user_id"; 
			ResultSet resultSet1 = stmt.executeQuery(query1);
			resultSet1.next();
			usersPojo.setUserId(resultSet1.getInt(1));
			//String query2 = "SELECT * users WHERE username='"+usersPojo.getUsername()+"' AND password ='" +usersPojo.getPassword()+"'";
			//ResultSet resultSet2 = stmt.executeQuery(query2);
			//resultSet2.next();
			//accountDetailsPojo.setUserId(resultSet2.getInt(1));
			String addRecord = "INSERT INTO account_details(user_id) SELECT user_id FROM users ORDER BY user_id DESC LIMIT 1 returning user_id";
			ResultSet resultSet2 = stmt.executeQuery(addRecord);
			resultSet2.next();
			accountDetailsPojo.setUserId(resultSet2.getInt(1));
			//DBUtil.closeConnection;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
//		try {
//			conn = DBUtil.makeConnection();
//			Statement stmt = conn.createStatement();
//			String query = "INSERT INTO account_details(user_id) SELECT user_id FROM users";
//			stmt.executeQuery(query);
			//ResultSet resultSet = stmt.executeQuery(query);
			//resultSet.next();
			//accountDetailsPojo.setUserId(resultSet.getInt(2));
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new SystemException();
//		}
		return usersPojo;
	}

	@Override
	public UsersPojo loginUser(UsersPojo usersPojo) throws SystemException {
		Connection conn = null;
		//usersPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM users WHERE username="+"'"+usersPojo.getUsername()+"'"+"and password=" +"'"+ usersPojo.getPassword()+"'";
			ResultSet resultSet = stmt.executeQuery(query);
			if (resultSet.next()) {
				//usersPojo = new UsersPojo(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
				usersPojo.setUserId(resultSet.getInt(1));
				//usersPojo.setUsername(resultSet.getString(2));
				//usersPojo.setPassword(resultSet.getString(3));
			}
		} catch (SQLException e) {
			throw new SystemException();
		}
		return usersPojo;
	}

}
