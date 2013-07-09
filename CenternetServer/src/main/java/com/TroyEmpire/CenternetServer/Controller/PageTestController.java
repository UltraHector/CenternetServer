package com.TroyEmpire.CenternetServer.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageTestController {
	
	@RequestMapping(value="/pagetest",method=RequestMethod.GET)
	public String PageTestGet(){
		return "pagetest";
	}
}
