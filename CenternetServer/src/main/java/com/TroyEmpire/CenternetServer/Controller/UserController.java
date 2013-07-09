package com.TroyEmpire.CenternetServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IDAO.IUserDAO;

@Controller
public class UserController {

	@Autowired
	private IUserDAO userDao;

	@RequestMapping(value = "/createNewUser", method = RequestMethod.GET)
	public ModelAndView createNewUser() {
		User user = new User();
		userDao.save(user);
		return new ModelAndView("...");
	}

}
