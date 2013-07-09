package com.TroyEmpire.CenternetServer.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TroyEmpire.CenternetServer.Util.MathUtil;
import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IDAO.IUserDAO;
import com.TroyEmpire.CenternetServer.IService.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Override
	public boolean checkUserIfExistByEmain(String email) {
		if (userDao.getUserByEmail(email) == null) {
			return false;
		} else
			return true;
	}

	@Override
	public void saveUser(User user) {
		userDao.save(user);
	}

	@Override
	public User validateUser(String email, String userpwd) {
		User user = userDao.getUserByEmail(email);
		try {
			if (user == null) {
				return null;
			}
			if (MathUtil.Md5(userpwd).equals(user.getPassword())) {
				return user;
			} else {
				return null;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getALlUsers() {
		return userDao.findAll(User.class);
	}

}
