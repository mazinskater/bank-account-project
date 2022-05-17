package dao;

import exception.OverDraftException;
import exception.SystemException;
import model.AccountDetailsPojo;

public interface AccountDetailsDao {
	
		//Withdraw funds
		AccountDetailsPojo withdrawFunds(AccountDetailsPojo accountDetailsPojo)throws SystemException, OverDraftException;
		//Deposit funds
		AccountDetailsPojo depositFunds(AccountDetailsPojo accountDetailsPojo)throws SystemException;
		//Read user account
		AccountDetailsPojo getAUserAccount(int userId)throws SystemException;
		

}
