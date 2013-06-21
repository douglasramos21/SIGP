package com.patrimonio.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.patrimonio.master.GenericMB;
import com.patrimonio.model.User;
import com.patrimonio.service.UserBP;

@RequestScoped
@ManagedBean
public class LoginMB extends GenericMB {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7182188781485350347L;

	@ManagedProperty(value = UserMB.INJECTION_NAME)
	private UserMB userMB;

	private String email;
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String login() {
		UserBP userBP = new UserBP();

		User user = userBP.isValidLogin(email, password);

		if (user != null) {
			userMB.setUser(user);
			// HttpServletRequest request = (HttpServletRequest)
			// context.getExternalContext().getRequest();
			// request.getSession().setAttribute("user", user);
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getSessionMap().put("user", user);

			return "/index.xhtml";
		}

		displayErrorMessageToUser("Check your email/password");

		return null;
	}

	public String logout() {

		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		userMB.setUser(null);

		return "/login.xhtml";

	}

	public void setUserMB(UserMB userMB) {
		this.userMB = userMB;
	}
}