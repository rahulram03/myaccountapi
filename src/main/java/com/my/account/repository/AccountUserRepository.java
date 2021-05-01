package com.my.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.account.domain.AccountUser;

@Repository
public interface AccountUserRepository extends JpaRepository<AccountUser, Long> {

	AccountUser findByUsername(String username);
}