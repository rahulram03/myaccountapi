package com.my.account.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.my.account.domain.AccountUser;
import com.my.account.domain.LoginUser;
import com.my.account.domain.Status;
import com.my.account.repository.AccountUserRepository;

@RestController
public class MyAccountController {

	@Autowired
	AccountUserRepository accountUserRepository;

	@CrossOrigin()
	@PostMapping("/users/register")
	public Status registerUser(@Valid @RequestBody AccountUser newUser) {
		List<AccountUser> users = accountUserRepository.findAll();

		for (AccountUser user : users) {
			if (user.equals(newUser)) {
				System.out.println("User Already exists!");
				return Status.USER_ALREADY_EXISTS;
			}
		}

		accountUserRepository.save(newUser);
		return Status.SUCCESS;
	}

	@CrossOrigin()
	@PostMapping("/users/login")
	public Status loginUser(@Valid @RequestBody LoginUser user) {
		AccountUser accountUser = accountUserRepository.findByUsername(user.getUsername());

		if (accountUser != null) {
			accountUser.setLoggedIn(true);
			accountUserRepository.save(accountUser);
			return Status.SUCCESS;
		}

		return Status.FAILURE;
	}

	@CrossOrigin()
	@PostMapping("/users/logout")
	public Status logUserOut(@Valid @RequestBody AccountUser user) {
		List<AccountUser> users = accountUserRepository.findAll();

		for (AccountUser other : users) {
			if (other.equals(user)) {
				user.setLoggedIn(false);
				accountUserRepository.save(user);
				return Status.SUCCESS;
			}
		}

		return Status.FAILURE;
	}
}
