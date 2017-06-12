package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;

@Controller
public class AdminController {
	
	
	//SLF4J  -> Simple Logging Facade for Java 
	
	private static  Logger log = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	HttpSession session;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	
	@RequestMapping("/manageCategories")
	public ModelAndView manageCategories()
	{
		
		log.debug("Starting of the method manageCategories");
		
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		
		log.debug("End of the method manageCategories");
		return mv;
		
		
	}
	@RequestMapping("/manageSupplier")
	public ModelAndView manageSuppliers()
	{
		log.debug("Starting of the method manageSuppliers");
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedSuppliers", "true");
		session.setAttribute("supplierList", supplierDAO.list());
		session.setAttribute("supplier",supplier);
		log.debug("Ending of the method manageSuppliers");
		return mv;
		
		
	}
	@RequestMapping("/manageProducts")
	public ModelAndView manageProducts()
	{
		log.debug("Starting of the method manageProducts");
		
		ModelAndView mv = new ModelAndView("Home");
		mv.addObject("isAdmin","true");
		mv.addObject("isAdminClickedProducts","true");
		session.setAttribute("productList", productDAO.list());
		session.setAttribute("product",product);
		mv.addObject("productList", productDAO.list());
		mv.addObject("product", product);
		mv.addObject("category",category);
		mv.addObject("categoryList",categoryDAO.list());
		mv.addObject("supplier",supplier);
		mv.addObject("supplierList",supplierDAO.list());
		log.debug("Ending of the method manageProducts");
		return mv;
		
		
	}

}
