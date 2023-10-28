package com.spring.book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.book.entity.Book;

public interface BookDAO extends JpaRepository<Book,Integer> {

	public List<Book> findByName(String name);
}
