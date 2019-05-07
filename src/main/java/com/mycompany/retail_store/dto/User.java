package com.mycompany.retail_store.dto;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.mycompany.retail_store.UserType;

/*
 * User Class to store information about user that buy 
 */
public class User {

	private final UserType type;
	private final String userName;
	private final LocalDateTime joiningDate;

	/**
	 * Method is used to convert data from json to oject
	 * 
	 * @param object
	 * @return
	 */
	@JsonCreator
	public static User create(Map<String, Object> object) {
		return new User(UserType.valueOf((String) object.get("type")), (String) object.get("userName"));
	}

	/*
	 * Could add more fields like name, address etc etc.
	 */

	public User(UserType type, String userName) {
		this.type = type;
		this.userName = userName;
		joiningDate = LocalDateTime.now();
	}

	public User(UserType type, String userName, LocalDateTime joiningDate) {
		this.type = type;
		this.userName = userName;
		this.joiningDate = joiningDate;
	}

	public UserType getType() {
		return type;
	}

	public String getUserName() {
		return userName;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

}
