package com.barbershop.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.barbershop.com.model.UserRegisterModel;


@Repository
@Transactional
public interface UserRegisterRepository extends JpaRepository<UserRegisterModel, Long> {
 
	@Query("select u from UserRegisterModel u where u.email = ?1")
	UserRegisterModel findUserByLogin(String username);
}
