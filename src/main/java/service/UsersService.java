package service;

import exception.SystemException;
import model.AccountDetailsPojo;
import model.UsersPojo;

public interface UsersService {
	
		//Register new user
		UsersPojo addUser(UsersPojo userPojo, AccountDetailsPojo accountDetailsPojo)throws SystemException;
		//Login User
		UsersPojo loginUser(UsersPojo userPojo)throws SystemException;
		

}
