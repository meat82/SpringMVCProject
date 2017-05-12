package com.meat.sql.jdbc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.mapper.PersonMapper;
import com.meat.sql.utils.SQLPersonCommands;
import com.meat.sql.utils.SQLLogger;

public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);

    @Autowired
    private JdbcTemplate personTemplate;

    public JdbcTemplate getPersonTemplate() {
        return personTemplate;
    }

    public void setPersonTemplate(JdbcTemplate personTemplate) {
        this.personTemplate = personTemplate;
    }

    @Override
    public void addPerson(Person person) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.INSERT,
                    new String[] { person.getUserId(), person.getFirstName(), person.getLastName(), person.geteMail(),
                            person.getPhone(), person.getStatus(), person.getPassWord(), person.getUserName() }));
        }
        personTemplate.update(SQLPersonCommands.INSERT,
                new Object[] { person.getUserId(), person.getFirstName(), person.getLastName(), person.geteMail(),
                        person.getPhone(), person.getStatus(), person.getPassWord(), person.getUserName() });
    }

    @Override
    public List<Person> getPersonByUserName(String userName) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: "
                    + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERNAME, new String[] { userName }));
        }

        return personTemplate.query(SQLPersonCommands.SELECT_USERNAME, new Object[] { userName }, new PersonMapper());
    }

    @Override
    public boolean isValid(String userName, String passWord) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERNAME_AND_PASSWORD,
                    new String[] { userName, passWord }));
        }
        List<Person> persons = personTemplate.query(SQLPersonCommands.SELECT_USERNAME_AND_PASSWORD,
                new Object[] { userName, passWord }, new PersonMapper());
        if (persons.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public List<Person> listAll() {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLPersonCommands.SELECT_ALL);
        }
        List<Person> persons = this.personTemplate.query(SQLPersonCommands.SELECT_ALL, new PersonMapper());
        return persons;
    }

    @Override
    public Person getPerson(String userId) {
        if (logger.isDebugEnabled()) {
            logger.debug(
                    "SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERID, new String[] { userId }));
        }
        List<Person> result = this.personTemplate.query(SQLPersonCommands.SELECT_USERID, new Object[] { userId },
                new PersonMapper());
        if (result != null && !result.isEmpty()) {
            return result.get(0);
        }
        return null;
    }

    @Override
    public int deletePerson(String userId) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.DELETE, new String[] { userId }));
        }
        return this.personTemplate.update(SQLPersonCommands.DELETE, new Object[] { userId });
    }

    @Override
    public void modifyPerson(Person person) {
        // TODO Auto-generated method stub

    }

}
