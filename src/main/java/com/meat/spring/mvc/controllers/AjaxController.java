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
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.meat.spring.mvc.ajax.PersonResponseBody;
import com.meat.spring.mvc.ajax.Views;
import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.services.PersonService;

/**
 * Handles all Ajax calls
 */
@RestController
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
     * @ResponseBody, not necessary, since class is annotated with @RestController
     * @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
     * @JsonView(Views.Public.class) - Optional, filters json data to display
     * 
     * @param userId
     * @return Person
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/getPerson", method = RequestMethod.POST)
    @ResponseBody
    public PersonResponseBody getUser(@RequestBody String userId) {

        logger.info("userId: " + userId);
        PersonResponseBody result = new PersonResponseBody();
        Person person = personService.getPerson(userId);
        if (person != null) {
            result.setCode("200");
            result.setMsg("");
            result.setResult(person);
        } else {
            result.setCode("204");
            result.setMsg("No person found!");
        }

        return result;
    }
    /**
     * Get person using unique userId
     * @ResponseBody, not necessary, since class is annotated with @RestController
     * @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
     * @JsonView(Views.Public.class) - Optional, filters json data to display
     * 
     * @param userId
     * @return Person
     */
    @JsonView(Views.Public.class)
    @RequestMapping(value = "/deletePerson", method = RequestMethod.POST)
    @ResponseBody
    public PersonResponseBody deletePerson(@RequestBody String userId){
        PersonResponseBody result = new PersonResponseBody();
        personService.deletePerson(userId);
        result.setCode("200");
        result.setMsg("Person row deleted!");
        return result;
    }
}
