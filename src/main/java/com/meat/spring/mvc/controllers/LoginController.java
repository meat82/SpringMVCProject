package com.meat.spring.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.meat.sql.jdbc.services.PersonService;

@Controller
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

	@Autowired
	PersonService personService;

    /**
     * Simply selects the home view to render by returning its name.
     */
	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout , HttpServletRequest request) {

	    LOGGER.info("username: " + request.getParameter("username"));
	    LOGGER.info("error: " + error);

	    ModelAndView model = new ModelAndView();
	    if (error != null) {
	        model.addObject("error", "Invalid username and password!");
	    }

	    if (logout != null) {
	        model.addObject("msg", "You've been logged out successfully.");
	    }
	    model.setViewName("auth");

	    return model;

	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "login?logout=true";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}


}
