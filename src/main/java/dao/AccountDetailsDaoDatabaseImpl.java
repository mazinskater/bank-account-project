package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exception.OverDraftException;
import exception.SystemException;
import model.AccountDetailsPojo;

public class AccountDetailsDaoDatabaseImpl implements AccountDetailsDao {

	@Override
	public AccountDetailsPojo withdrawFunds(AccountDetailsPojo accountDetailsPojo)
			throws SystemException, OverDraftException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE account_details SET funds=" + accountDetailsPojo.getFunds() + "WHERE user_id =" + accountDetailsPojo.getUserId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return accountDetailsPojo;
	}

	@Override
	public AccountDetailsPojo depositFunds(AccountDetailsPojo accountDetailsPojo) throws SystemException {
		Connection conn = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "UPDATE account_details SET funds=" + accountDetailsPojo.getFunds() + "WHERE user_id =" + accountDetailsPojo.getUserId();
			int rowsAffected = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SystemException();
		}
		return accountDetailsPojo;
	}


	@Override
	public AccountDetailsPojo getAUserAccount(int userId) throws SystemException {
		Connection conn = null;
		AccountDetailsPojo accountDetailsPojo = null;
		try {
			conn = DBUtil.makeConnection();
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM account_details WHERE user_id ="+userId;
			ResultSet resultSet = stmt.executeQuery(query);
			if(resultSet.next()) {
				accountDetailsPojo = new AccountDetailsPojo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getDouble(3));
			}
		}catch (SQLException e) {
				throw new SystemException();
			}	
		return accountDetailsPojo;
	}

	

}
