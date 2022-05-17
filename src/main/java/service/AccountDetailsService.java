package service;

import exception.OverDraftException;
import exception.SystemException;
import model.AccountDetailsPojo;

public interface AccountDetailsService {
	
	AccountDetailsPojo withdrawFunds(AccountDetailsPojo accountDetailsPojo)throws SystemException, OverDraftException;
	
	AccountDetailsPojo depositFunds(AccountDetailsPojo accountDetailsPojo)throws SystemException;
	
	AccountDetailsPojo getAUserAccount(int userId)throws SystemException;
}
