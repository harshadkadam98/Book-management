package com.spring.book.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="books_detail")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_number")
	private int bookNumber;
	@Column(name="name")
	private String name;
	@Column(name="author")
	private String author;
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public Book(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}
	
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [book_Number=" + bookNumber + ", name=" + name + ", author=" + author + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(bookNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return bookNumber == other.bookNumber;
	}
	
	
}
