package com.meat.sql.utils;

public interface SQLPersonCommands {

    public static final String DELETE = "DELETE FROM production.persons WHERE id_persons=?";
    public static final String INSERT = "INSERT INTO production.persons (id_persons,first_name,last_name,mail,phone,status,password,username) VALUES (?,?,?,?,?,?,?,?)";
    public static final String SELECT_ALL = "SELECT * FROM production.persons";
    public static final String SELECT_USERID = "SELECT * FROM production.persons WHERE id_persons=?";
    public static final String SELECT_USERNAME = "SELECT * FROM production.persons WHERE username=?";
    public static final String SELECT_USERNAME_AND_PASSWORD = "SELECT * FROM production.persons WHERE username=? and password=?";
    public static final String UPDATE = "UPDATE production.persons SET first_name=?,last_name=?,mail=?,phone=?,status=? WHERE id_persons=?";
}
