package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Supplier;
import com.niit.shoppingcartbackend.domain.User;


@Controller
public class UserController {
	
	
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired UserDAO userDAO;
	@Autowired User  user;
	@Autowired CategoryDAO categoryDAO;
	@Autowired  Category  category;
	@Autowired SupplierDAO supplierDAO;
	@Autowired Supplier supplier;
	@Autowired HttpSession session;
	
	
		//Get the user id and password from login page
	//send these values to userDAO.validate
	//based on response, you can navigate to either login.jps or Home.jsp
	
	//Whenever we configure spring security - we can remove this method
	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("emailid") String id, 
			@RequestParam("password") String password)
	
	{
		
		log.debug("Starting of the method login");
		
		log.info("You are login with the id "+id);
		ModelAndView mv = new ModelAndView("/Home");
		 if(userDAO.validate(id, password)==true)
		 {
			 log.debug("Valid credentials");
			 
			 user = userDAO.get(id);
			 
			 //${message}  - to display in the Home.jsp
			 mv.addObject("message", " Welcome " + user.getName());
			 
			 mv.addObject("categoryList", categoryDAO.list());
			 mv.addObject("category", category);
			 
			 mv.addObject("supplierList", supplierDAO.list());
			 mv.addObject("supplier", supplierDAO);
			 
			 session.setAttribute("userName", user.getName());
			 session.setAttribute("loggedInUserID", id);
			 mv.addObject("isUserAtHomePage","true");
			 
			 //check whether user is customer or admin
			 
			 if(user.getRole().equals("admin"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "admin");
			 }
			 else
			 {
				 log.debug("You are User");
				 mv.addObject("isAdmin", "false");
				 session.setAttribute("role", "user");
					session.setAttribute("isUserLoggedIn", "true");
					session.setAttribute("isUserAtHomePage","true");
					 
			 }
				 }
		 else
		 {
			 log.debug("Invalid user");
			 mv.addObject("message", "Invalid credentials..please try again.");
		 }
		 
		 log.debug("Ending of the method login");
		 return mv;
		
	}
		
	//We need to implement
	//create user
	//update user
	//getAllUsers
	//
	@RequestMapping("/registered")
	public String addUser(@RequestParam("emailid") String id,@RequestParam("username") String name,@RequestParam("password") String password,@RequestParam("contact") String contact,@RequestParam("role") String role,RedirectAttributes redirectAttributes){
		
		user.setId(id);
		user.setName(name);
		user.setPassword(password);
		user.setContact(contact);
		user.setRole(role);
		
		if(userDAO.get(id)!=null){
			// category already exist
			//mv.addObject("message","Category Already Exist with the id "+id);
			redirectAttributes.addFlashAttribute("idmessage", "User Already Exist with the id "+id);
			}
		else{
			userDAO.save(user);
			redirectAttributes.addFlashAttribute("message", "User Added Successfully");
		}
				
		return "Home";
	}
}
