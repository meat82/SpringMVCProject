package com.meat.sql.utils;

public interface SQLCommand {

	public static final String SQL_SELECT_ALL = "select * from production.persons";
	public static final String SQL_ADD_PERSON = "insert into production.persons (id_persons,first_name,last_name,mail,phone,status,password) VALUES (?,?,?,?,?,?,?)";
}