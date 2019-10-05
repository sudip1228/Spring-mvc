package com.in28minutes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class springmvc {

	@Autowired
	LoginService service;
	@RequestMapping(value= "/login", method= RequestMethod.GET)//it indicates dispatherservlet
	//@ResponseBody //it displays output on the screen.
	public String showloginpage()
	{
		return "log";// "log" is used by dispather control to resolve the view.since there is no responsebody annotation, the "log" cant be printed.so dispatcher search for log.jsp in web-inf-views where it finds log.jsp.Thus, it redirects to log.jsp
	}
	@RequestMapping(value= "/login", method= RequestMethod.POST)
	public String handleloginrequest(@RequestParam String name,ModelMap model,@RequestParam String password)//"name" should match (Enter your name<input type="text" name="name"/> ) in log.jsp page.Here we are setting a parameter as we used to do in jsp and servlet.
	{
	if(	!service.validateUser(name, password))
	{
		model.put("errorMessage","invalid name or password");
		return "log";
	}
		model.put("password",password);
		model.put("name",name);//now the name parameter is available to view or jsp because of model.
		return "welcome";// "log" is used by dispatcher control to resolve the view.since there is no responsebody annotation, the "log" cant be printed.so dispatcher search for log.jsp in web-inf-views where it finds log.jsp.Thus, it redirects to log.jsp

	
	
}
}
