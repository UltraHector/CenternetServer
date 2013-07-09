package com.TroyEmpire.CenternetServer.Controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.TroyEmpire.CenternetServer.Util.MathUtil;
import com.TroyEmpire.CenternetServer.Entity.User;
import com.TroyEmpire.CenternetServer.IService.IUserService;
import com.TroyEmpire.CenternetServer.Util.CaptchaUtil;

@Controller
public class RegisterController {

	@Autowired
	private IUserService userService;

	private String sImgType = "jpg";

	/**
	 * @param value
	 *            对应请求的url链接是/register
	 * @param method
	 *            对应请求页面的http方法是GET
	 * @return 转移到register.jsp页面
	 * */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerGet() {
		return "register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPost(HttpServletRequest request,
			HttpServletResponse response) {
		User user = new User();
		try {
			user.setEmail(request.getParameter("user_email"));
			user.setName(request.getParameter("user_name"));
			user.setAddDate(new Date());
			user.setPassword(MathUtil.Md5(request.getParameter("user_password")));
			userService.saveUser(user);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("index");
	}

	@RequestMapping(value = "/register/validateEmail", method = RequestMethod.GET)
	public void ajaxValidateEmail(HttpServletRequest request,
			HttpServletResponse response) {
		String email = request.getParameter("email");
		if (userService.checkUserIfExistByEmain(email)) {
			try {
				response.getWriter().write("exist");
				response.getWriter().flush();
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		}
	}

	@RequestMapping(value = "/register/validateCaptcha", method = RequestMethod.GET)
	public void ajaxValidateCaptcha(HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		String hidCaptchaID = request.getSession().getId();
		String veriCode = request.getParameter("veriCode");
		String message = "";
		if (hidCaptchaID == null || veriCode == null) {
			message = "fault";
		} else {
			boolean passedCaptchaTest = CaptchaUtil.validateCaptcha(
					hidCaptchaID, veriCode);
			message = passedCaptchaTest ? "pass" : "unpass";
		}
		try {
			response.getWriter().write(message);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param value
	 *            对应register.js里面的使用aJax提交表单的Url
	 * @param method
	 *            对应register.js里面的使用aJax提交表单的type
	 * @param request
	 *            对应页面的request对象
	 * @param response
	 *            对应页面的response对象
	 * @return return create the image of validation and return it
	 * */
	@RequestMapping(value = "/register/captcha", method = RequestMethod.GET)
	public void getCaptcha(HttpServletRequest request,
			HttpServletResponse response) {
		ByteArrayOutputStream imgOutputStream = new ByteArrayOutputStream();
		byte[] captchaBytes;
		if (request.getQueryString() != null) {
			return;
		}
		try {
			// Session ID is used to identify the particular captcha.
			String captchaId = request.getSession().getId();
			// Generate the captcha image.
			BufferedImage challengeImage = CaptchaUtil.getInstance()
					.getImageChallengeForID(captchaId, request.getLocale());
			ImageIO.write(challengeImage, sImgType, imgOutputStream);
			captchaBytes = imgOutputStream.toByteArray();
			// Set appropriate http headers.
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/" + sImgType);
			// Write the image to the client.
			ServletOutputStream outStream;
			outStream = response.getOutputStream();
			outStream.write(captchaBytes);
			outStream.flush();
			outStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
