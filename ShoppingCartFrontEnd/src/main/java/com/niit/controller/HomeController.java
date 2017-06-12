package com.niit.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.MyCartDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.MyCart;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;

@Controller
public class HomeController {
	
	
	//Whenever the user open our website, it should navigate to home page
	//http://localhost:8080/ShoppingCart/
	
	@Autowired
	HttpSession session;

	@Autowired
	Category category;
	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	MyCart myCart;
	
	@Autowired
	MyCartDAO myCartDAO; 


	@RequestMapping("/")
	public ModelAndView goToHome() {
		System.out.println("Going Home...");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("message", "Thank you for visiting Shopping Cart! <br>");
		// model.addAttribute("message", "Thank you for visiting Shopping Cart!
		// <br>");
		mv.addObject("isUserClickedHome", "true");
		mv.addObject("isUserAtHomePage","true");
		mv.addObject("isUserLoggedIn", "false");
		mv.addObject("isAdmin", "false");
		List<Category> categoryList = categoryDAO.list();	

		// attach to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);
		
		List<Supplier> supplierList = supplierDAO.list();	
		
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier",supplier);
		
		List<Product> productList = productDAO.list();
		
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);
		
		mv.addObject("productList", productList);
		mv.addObject("product", product);
		return mv;
	}
	
	@RequestMapping("/Home")
	public ModelAndView goToHomeButton() {
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isUserAtHomePage", "true");
		
		// get all categories
		List<Category> categoryList = categoryDAO.list();

		// attach category to session
		session.setAttribute("categoryList", categoryList);
		session.setAttribute("category", category);

		// get products
		List<Product> productList = productDAO.list();

		// attach products to session
		session.setAttribute("productList", productList);
		session.setAttribute("product", product);

		// get products
		List<Supplier> supplierList = supplierDAO.list();

		// attach supplier to session
		session.setAttribute("supplierList", supplierList);
		session.setAttribute("supplier", supplier);

		return mv;
		// return "Home";
	}
	
	@RequestMapping("/LoginPage")
	public String loginPage(Model model)
	{
		model.addAttribute("isUserClickedLogin", "true");
		model.addAttribute("isUserAtHomePage", "false");
		model.addAttribute("isUserLoggedIn","false");
		

		Long currentTime = System.currentTimeMillis();
		Date currentDate = new Date(currentTime);

	
		return "Home";
	}
	
	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegister", "true");
		
		return "Home";
	}
	
	@RequestMapping("/CartPage")
	public ModelAndView cartPage(Model model) {
		model.addAttribute("isUserClickedCart", "true");
		ModelAndView mv=new ModelAndView("Home");
		;
		//session.setAttribute("cartList", myCartDAO.list(userID));;
		return mv;
}	
	@RequestMapping("/SignOut")
	public ModelAndView userSignOut() {
		//log.debug("Signout Initiated");
		ModelAndView mv = new ModelAndView("redirect:/");
		session.setAttribute("isUserLoggedIn", "false");
		session.setAttribute("isAdmin", "false");
		mv.addObject("isUserAtHomePage","true");
		return mv;
	}
}
	