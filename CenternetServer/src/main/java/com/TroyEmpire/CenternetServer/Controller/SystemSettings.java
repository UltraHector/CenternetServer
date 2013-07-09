package com.TroyEmpire.CenternetServer.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IService.IUserService;

@Controller
public class SystemSettings {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/settings")
	public ModelAndView settings(ModelAndView model) {
		List<User> users = userService.getALlUsers();
		model.addObject("users", users);
		model.setViewName("settings");
		return model;

	}
}
