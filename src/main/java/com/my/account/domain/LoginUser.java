package com.my.account.domain;

import javax.validation.constraints.NotBlank;

public class LoginUser {

	private @NotBlank String username;
	private @NotBlank String password;

	public LoginUser() {
	}

	public LoginUser(@NotBlank String username, @NotBlank String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
