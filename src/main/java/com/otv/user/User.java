package com.otv.user;

import java.io.Serializable;

/**
 * @author onlinetechvision.com
 * @since 9 Oct 2011
 * @version 1.0.0
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	
	public User(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("name : ").append(name);
		strBuff.append(", surname : ").append(surname);
		return strBuff.toString();
	}
}
