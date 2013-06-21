package com.patrimonio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.patrimonio.master.EntityBean;

@Entity
@Table(schema = "public", name = "users")
public class User extends EntityBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5607591381928924197L;

	private String email;

	private String password;

	private String name;

	/**
	 * Columns
	 */
	@Column(name = "email", unique = true)
	public String getEmail() {
		return email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	/**
	 * Setters
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

}