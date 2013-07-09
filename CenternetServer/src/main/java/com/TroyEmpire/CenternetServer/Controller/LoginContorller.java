package com.TroyEmpire.CenternetServer.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IService.IUserService;

@Controller
public class LoginContorller {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void loginPost(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		String userName = request.getParameter("username");
		String userPwd = request.getParameter("userpwd");
		User user = null;
		response.setCharacterEncoding("utf-8");
		user = userService.validateUser(userName, userPwd);
		if (user != null) {
			session.setAttribute("user", user);
		} else {
			try {
				response.getWriter().write("用户账户或密码错误");
				response.getWriter().flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}

}
