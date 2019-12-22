package com.example.cipherchatzy.Repository;

import org.springframework.stereotype.Repository;

import com.example.cipherchatzy.Model.UserModel;

import org.springframework.data.jpa.repository. JpaRepository;


@Repository
public interface UserDao extends JpaRepository<UserModel, Long> {
	UserModel findByEmail(String email);
	

}
