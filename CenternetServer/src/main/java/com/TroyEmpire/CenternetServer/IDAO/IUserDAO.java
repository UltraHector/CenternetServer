package com.TroyEmpire.CenternetServer.IDAO;

import com.TroyEmpire.CenternetServer.Entity.User;

public interface IUserDAO extends IDAO<User, Long> {
	/**
	 * get the user by name
	 * 
	 * @param username
	 */
	User getUserByName(String username);
	
	boolean whetherUserExists();
	
	User getUserByEmail(String email);
}
