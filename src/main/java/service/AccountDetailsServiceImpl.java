package service;

import dao.AccountDetailsDao;
import dao.AccountDetailsDaoDatabaseImpl;
import exception.OverDraftException;
import exception.SystemException;
import model.AccountDetailsPojo;

public class AccountDetailsServiceImpl implements AccountDetailsService {

	AccountDetailsDao accountDetailsDao;
	
	public AccountDetailsServiceImpl() {
		accountDetailsDao = new AccountDetailsDaoDatabaseImpl();
	}
	
	public AccountDetailsDao getAccountDetailsDao() {
		return accountDetailsDao;
	}



	public void setAccountDetailsDao(AccountDetailsDao accountDetailsDao) {
		this.accountDetailsDao = accountDetailsDao;
	}



	@Override
	public AccountDetailsPojo withdrawFunds(AccountDetailsPojo accountDetailsPojo)
			throws SystemException, OverDraftException {
		
		if(accountDetailsPojo.getFunds() < 0) {
			System.out.println("Account is overdrawn. Can not proceed with transaction");
		}
		
		return accountDetailsDao.withdrawFunds(accountDetailsPojo);
	}

	@Override
	public AccountDetailsPojo depositFunds(AccountDetailsPojo accountDetailsPojo) throws SystemException {
		
		return accountDetailsDao.depositFunds(accountDetailsPojo);
	}

	@Override
	public AccountDetailsPojo getAUserAccount(int userId) throws SystemException {
		return accountDetailsDao.getAUserAccount(userId);
	}

}
