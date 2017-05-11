package com.meat.spring.mvc.controllers;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meat.spring.mvc.ajax.PersonResponseBody;
import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AjaxController {

    private static final String EXISTS = "Username already exists: ";

    private static final Logger logger = Logger.getLogger(AjaxController.class);

    @Autowired
    PersonService personService;

    /**
     * Spring automatically binds the userId
     * 
     * @param person
     * @return String indicating success or failure of save
     */
    @RequestMapping(value = "/userId", method = RequestMethod.POST)
    @ResponseBody
    public String getUserID(Person person) {

        if (logger.isDebugEnabled()) {
            logger.debug(person.toString());
        }
        List<Person> persons = personService.getPersonByUserName(person.getUserName());

        if (persons.size() > 0) {
            return EXISTS + persons.get(0).getUserName();
        }
        return "";
    }

    /**
     * Get person using unique userId
     * 
     * @param userId
     * @return Person
     */
    @RequestMapping(value = "/getPerson", method = RequestMethod.POST)
    @ResponseBody
    public PersonResponseBody getUser(@RequestBody String userId) {
        
        logger.info("userId: " + userId);
        PersonResponseBody result = new PersonResponseBody();
        Person person = personService.getPerson(userId);
        result.setCode("200");
        result.setMsg("");
        result.setResult(person);
        
        return result;
    }
}
