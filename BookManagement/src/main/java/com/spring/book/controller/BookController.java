package com.spring.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.book.dao.BookDAO;
import com.spring.book.dao.MyUserDAO;
import com.spring.book.entity.Book;
import com.spring.book.entity.User;

@Controller
public class BookController {
	@Autowired
	BookDAO dao;
	@Autowired
	MyUserDAO dao1;
	public BookController() {
		// TODO Auto-generated constructor stub
	}
	
	
	@GetMapping("/books")
	public ModelAndView books() {
		
			List<Book> book=dao.findAll();
			ModelAndView mv= new ModelAndView("books");
			mv.addObject("book",book);
			return mv;
		}
	
	
	@GetMapping("/addBookPage")
	public ModelAndView addBookPage() {
		ModelAndView mv= new ModelAndView("addbook");
		mv.addObject("book",new Book());
		return mv;
	}
	
	@PostMapping("/addBook")
	public ModelAndView addBook(@RequestParam String author,@RequestParam String name) {
		Book book=new Book(author,name);
		dao.save(book);
		List<Book> books=dao.findAll();
		ModelAndView mv= new ModelAndView("books");
		mv.addObject("book",books);
		return mv;
	}
	
	
	@GetMapping("/updateBookPage")
	public ModelAndView updateBookPage() {
		ModelAndView mv= new ModelAndView("updatebook");
		mv.addObject("book",new Book());
		return mv;
	
	}
	
	@PostMapping("/updateBook")
	public ModelAndView updateBook(@RequestParam int bookNumber,@RequestParam String author,@RequestParam String name) {
		Book book=dao.findById(bookNumber).orElseThrow();
		book.setAuthor(author);
		book.setName(name);
		dao.save(book);
		List<Book> books=dao.findAll();
		ModelAndView mv= new ModelAndView("books");
		mv.addObject("book",books);
		return mv;
	}
	
	@GetMapping("/deleteBookPage")
	public ModelAndView deleteBookPage() {
		ModelAndView mv= new ModelAndView("deletebook");
		mv.addObject("book",new Book());
		return mv;
	
	}
	
	@PostMapping("/deleteBook")
	public ModelAndView deleteBook(@RequestParam int bookNumber) {
		dao.deleteById(bookNumber);
		List<Book> books=dao.findAll();
		ModelAndView mv= new ModelAndView("books");
		mv.addObject("book",books);
		return mv;
	}
}
