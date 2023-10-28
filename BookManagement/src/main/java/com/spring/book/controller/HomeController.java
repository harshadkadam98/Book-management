package com.spring.book.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.book.dao.BookDAO;
import com.spring.book.dao.MyUserDAO;
import com.spring.book.entity.Book;
import com.spring.book.entity.User;

@Controller
public class HomeController {

	@Autowired
	BookDAO dao1;
	
	@Autowired
	MyUserDAO dao;
	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	

	@GetMapping("/")
	public String welcome() {
		return "welcome";
		
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv= new ModelAndView("login");
		User user =new User();
		user.setUsername("someone@somehost.com");
		mv.addObject("user",user);
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView authenticate(@Valid User user, BindingResult result, HttpSession session) {
		ModelAndView mv= new ModelAndView("books");
		ModelAndView mv1= new ModelAndView("login");
		User users=dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		 if(users!=null) {
			session.setAttribute("user", user);
			List<Book> book=dao1.findAll();
			mv.addObject("book",book);
			return mv;
		}
		 return mv1;
	}
	
	@GetMapping("/registrationPage")
	public ModelAndView registrationPage() {
		ModelAndView mv= new ModelAndView("registration");
		User user =new User();
		user.setUsername("someone@somehost.com");
		mv.addObject("user",user);
		return mv;
	}

	
	@PostMapping("/registration")
	public ModelAndView registration(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String username, @RequestParam String password) {
		User user = new User(firstname,lastname,username,password);
		dao.save(user);
		ModelAndView mv= new ModelAndView("welcome");
		return mv;
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "welcome";
	}
}
