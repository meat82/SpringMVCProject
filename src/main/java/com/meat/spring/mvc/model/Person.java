package com.meat.spring.mvc.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.meat.spring.mvc.ajax.Views;

public class Person {
    
    @JsonView(Views.Public.class)
	private String userId;
	
	@JsonView(Views.Public.class)
	private String firstName;
	
	@JsonView(Views.Public.class)
	private String lastName;
	
	@JsonView(Views.Public.class)
	private String eMail;
	
	@JsonView(Views.Public.class)
	private String status;
	
	private String passWord;
	
	@JsonView(Views.Public.class)
	private String phone;
	
	@JsonView(Views.Public.class)
	private String userName;
	
	public Person() {
	    setFirstName("");
	    setLastName("");
	    setUserId("");
	    seteMail("");
	    setStatus("");
	    setPassWord("");
	    setPhone("");
	    setUserName("");
    }
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return phone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Person [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", eMail=" + eMail
				+ ", status=" + status + ", passWord=" + passWord + ", phone=" + phone + ", userName=" + userName + "]";
	}
	

}
