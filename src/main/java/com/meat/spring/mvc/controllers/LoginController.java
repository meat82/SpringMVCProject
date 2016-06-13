package com.meat.spring.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;

@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	PersonService personService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginForm(HttpServletRequest request, HttpServletResponse response,Person person) {
		
		String loggedIn = (String) request.getSession().getAttribute("loggedInUser");
		if(loggedIn != null) {
			request.setAttribute("loggedInUser", loggedIn);
			return new ModelAndView("loggedIn");
		}
		
		return new ModelAndView("login", "person", new Person());
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("SpringWeb") Person person) {

		
		boolean isValidUser = personService.isValidUser(person.getUserName(), person.getPassWord());
		ModelAndView model;
		if(isValidUser) {
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("User Login Successful");
			}
        	request.setAttribute("loggedInUser", person.getUserName());
        	request.getSession().setAttribute("loggedInUser", person.getUserName());
        	model = new ModelAndView("loginSuccess");
		}
		else {
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug("Failed!");
			}
        	model = new ModelAndView("loginDeny");			
		}
		return model;
	}
}
