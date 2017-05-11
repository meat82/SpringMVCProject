package com.meat.sql.utils;

public interface SQLCommand {

	public static final String SQL_SELECT_ALL = "select * from production.persons";
	public static final String SQL_ADD_PERSON = "insert into production.persons (id_persons,first_name,last_name,mail,phone,status,password,username) VALUES (?,?,?,?,?,?,?,?)";
	public static final String SQL_SELECT_USERNAME_AND_PASSWORD = "SELECT * FROM production.persons where username=? and password=?";
	public static final String SQL_SELECT_USERNAME = "SELECT * FROM production.persons where username=?";
	public static final String SQL_SELECT_USERID = "SELECT * FROM production.persons where id_persons=?";
}
