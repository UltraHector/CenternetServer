package com.TroyEmpire.CenternetServer.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TroyEmpire.CenternetServer.IDAO.IUserDAO;


@Controller
public class HomeController {
	
	@Autowired
	private IUserDAO userDao;
	
	@RequestMapping(value="/")
	public String home(){
		return "index";
	}
}
