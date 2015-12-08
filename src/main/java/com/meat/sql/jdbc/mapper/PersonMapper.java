package com.meat.sql.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.meat.spring.mvc.model.Person;

public class PersonMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

		Person person = new Person();
		person.setUserId(rs.getString("id_persons"));
		person.setFirstName(rs.getString("first_name"));
		person.setLastName(rs.getString("last_name"));
		person.seteMail(rs.getString("mail"));
		person.setPhone(rs.getString("phone"));
		person.setStatus(rs.getString("status"));
		person.setPassWord(rs.getString("password"));
		return person;
	}



}
