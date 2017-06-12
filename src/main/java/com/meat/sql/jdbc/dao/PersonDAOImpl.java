package com.meat.sql.jdbc.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.meat.spring.mvc.model.Person;
import com.meat.sql.jdbc.mapper.PersonMapper;
import com.meat.sql.utils.SQLLogger;
import com.meat.sql.utils.SQLPersonCommands;

public class PersonDAOImpl implements PersonDAO {

    private static final Logger logger = Logger.getLogger(PersonDAOImpl.class);

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addPerson(Person person) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.INSERT,
                    new String[] { person.getUserId(), person.getFirstName(), person.getLastName(), person.geteMail(),
                            person.getPhone(), person.getStatus(), person.getPassWord(), person.getUserName() }));
        }
        jdbcTemplate.update(SQLPersonCommands.INSERT,
                new Object[] { person.getUserId(), person.getFirstName(), person.getLastName(), person.geteMail(),
                        person.getPhone(), person.getStatus(), person.getPassWord(), person.getUserName() });
    }

    @Override
    public List<Person> getPersonByUserName(String userName) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: "
                    + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERNAME, new String[] { userName }));
        }

        return jdbcTemplate.query(SQLPersonCommands.SELECT_USERNAME, new Object[] { userName }, new PersonMapper());
    }

    @Override
    public boolean isValid(String userName, String passWord) {
        if (logger.isDebugEnabled()) {
            logger.debug("SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERNAME_AND_PASSWORD,
                    new String[] { userName, passWord }));
        }
        List<Person> persons = jdbcTemplate.query(SQLPersonCommands.SELECT_USERNAME_AND_PASSWORD,
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
        List<Person> persons = this.jdbcTemplate.query(SQLPersonCommands.SELECT_ALL, new PersonMapper());
        return persons;
    }

    @Override
    public Person getPerson(String userId) {
        if (logger.isDebugEnabled()) {
            logger.debug(
                    "SQL Statement: " + SQLLogger.getSQLLog(SQLPersonCommands.SELECT_USERID, new String[] { userId }));
        }
        List<Person> result = this.jdbcTemplate.query(SQLPersonCommands.SELECT_USERID, new Object[] { userId },
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
        return this.jdbcTemplate.update(SQLPersonCommands.DELETE, new Object[] { userId });
    }

    @Override
    public void modifyPerson(Person person) {
        this.jdbcTemplate.update(SQLPersonCommands.UPDATE, new Object[] { person.getFirstName(), person.getLastName(),
                person.geteMail(), person.getPhone(), person.getStatus(), person.getUserId() });

    }

}
