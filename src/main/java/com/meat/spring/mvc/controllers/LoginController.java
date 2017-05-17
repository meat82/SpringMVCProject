package com.meat.spring.mvc.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;

@Controller
public class LoginController {

	private static final Logger LOGGER = Logger.getLogger(LoginController.class);

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
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String login(Model model) {
        
        LOGGER.info("auth: ");
        
        return "auth";
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
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logoutUser(HttpServletRequest request, HttpServletResponse response,Person person) {
        
        String loggedInUser = (String) request.getSession().getAttribute("loggedInUser");
        if(loggedInUser != null) {
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("Ready to logout user: " + loggedInUser);
            }
            request.getSession().removeAttribute("loggedInUser");
            return new ModelAndView("logout");
        }
        //if user haven't logged in before log out go to login
        return new ModelAndView("login", "person", new Person()); 
    }
}
