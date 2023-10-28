package com.spring.book.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.book.entity.User;

public interface MyUserDAO extends JpaRepository<User,Integer>{
	
	public User findUserByUsernameAndPassword(String username,String password);
}
