package com.meat.spring.mvc.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BaseController {
	
	private static final Logger logger = Logger.getLogger(BaseController.class);
	
	@Autowired
	PersonService personService;

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}." + locale);
		
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
	    logger.info("Welcome home! The client locale is {}." + locale);
				
		
		model.addAttribute("serverTime", "nakki" );
		
		return "test";
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value="/form", method=RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("form","person",new Person());
    }
    
	/**
	 * Simply selects the home view to render by returning its name.
	 */
    @RequestMapping(value="/angular", method=RequestMethod.GET)
    public ModelAndView showAngular() {
        return new ModelAndView("angular");
    }
    
	/**
	 * Select tile view
	 */
    @RequestMapping(value="/tiles", method=RequestMethod.GET)
    public ModelAndView showTile() {
        return new ModelAndView("tiles");
    }
    
    @RequestMapping(value="/showAllPersons", method=RequestMethod.GET)
    public String showAllPersons(ModelMap model) {
    	List<Person> persons = personService.getPersons();
    	ObjectMapper mapper = new ObjectMapper();
    	String mappedValue = null;
    	try {
            mappedValue = mapper.writeValueAsString(persons);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	model.addAttribute("persons", mappedValue);
    	model.addAttribute("person", new Person());
    	return "showPersons";
    }
    
    @RequestMapping(value="/formProcess", method=RequestMethod.POST)
    public String processPersonForm(@ModelAttribute("SpringWeb")Person person) {
    	UUID id = UUID.randomUUID();
    	person.setUserId(id.toString());
    	person.setStatus("inactive");
        personService.addPerson(person);
        return "formProcess";
    }
    @RequestMapping(value="/formProcessEdit", method=RequestMethod.POST)
    public String processPersonFormEdit(@ModelAttribute("SpringWeb")Person person,ModelMap model) {
        personService.modifyPerson(person);
        List<Person> persons = personService.getPersons();
        ObjectMapper mapper = new ObjectMapper();
        String mappedValue = null;
        try {
            mappedValue = mapper.writeValueAsString(persons);
        } catch (JsonProcessingException e) {
            logger.error(e, e);
        }
        model.addAttribute("persons", mappedValue);
        model.addAttribute("person", new Person());
        return "showPersons";
    }
	
}
