package com.TroyEmpire.CenternetServer.IService;

import java.util.List;

import com.TroyEmpire.CenternetServer.Entity.User;

public interface IUserService {

	/**
	 *@param email user's email
	 *@return the result of if the user is existed
	 */
	boolean checkUserIfExistByEmain(String email);
	
	/**
	 * @param user the user to be saved
	 * @return to save the user
	 * */
	void saveUser(User user);
	
	/**
	 * @param email User's email 
	 * @param userpwd User's password
	 * @return if the password of the user is correct 
	 * */
	User validateUser(String email,String userpwd);
	
	/**
	 */
	
	List<User> getALlUsers();

}
