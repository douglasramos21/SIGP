package com.patrimonio.service;

import com.patrimonio.data.UserDAO;
import com.patrimonio.model.User;


public class UserBP {
	private UserDAO userDAO = new UserDAO();

	public User isValidLogin(String email, String password) {
		User user = (User) getUserDAO().findByEmail(email, User.class);

		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}

		return user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}