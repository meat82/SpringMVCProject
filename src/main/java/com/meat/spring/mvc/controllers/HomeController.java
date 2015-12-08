package com.meat.spring.mvc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;
import com.meat.sql.jdbc.services.PersonServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	PersonService personService;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		
		model.addAttribute("serverTime", "nakki" );
		
		return "test";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView showForm(Person person) {
        return new ModelAndView("form","person",new Person());
    }
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value="/angular", method=RequestMethod.GET)
    public ModelAndView showAngular() {
        return new ModelAndView("angular");
    }
    
    @RequestMapping(value="/showAllPersons", method=RequestMethod.GET)
    public ModelAndView showAllPersons() {
    	List<Person> persons = personService.getPersons();
        return new ModelAndView("showPersons","persons",persons);
    }
    
    @RequestMapping(value="/formProcess", method=RequestMethod.POST)
    public String processPersonForm(@ModelAttribute("SpringWeb")Person person) {
    	UUID id = UUID.randomUUID();
    	person.setUserId(id.toString());
    	person.setStatus("inactive");
        personService.addPerson(person);
        return "formProcess";
    }
    
	
}