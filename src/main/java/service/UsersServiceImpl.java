package service;

import dao.UsersDao;
import dao.UsersDaoDatabaseImpl;
import exception.SystemException;
import model.AccountDetailsPojo;
import model.UsersPojo;

public class UsersServiceImpl implements UsersService{

	UsersDao usersDao;
	
	public UsersServiceImpl() {
		usersDao = new UsersDaoDatabaseImpl();
	}
	
	public UsersDao getUsersDao() {
		return usersDao;
	}

	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}

	@Override
	public UsersPojo loginUser(UsersPojo userPojo) throws SystemException {
		UsersPojo returnedLoginUserPojo = this.usersDao.loginUser(userPojo);
		return returnedLoginUserPojo;
	}

	@Override
	public UsersPojo addUser(UsersPojo usersPojo, AccountDetailsPojo accountDetailsPojo) throws SystemException {
		return usersDao.addUser(usersPojo, accountDetailsPojo);
	}

}
