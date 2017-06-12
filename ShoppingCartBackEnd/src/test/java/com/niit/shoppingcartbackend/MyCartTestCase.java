/*package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.MyCartDAO;
import com.niit.shoppingcartbackend.domain.MyCart;


public class MyCartTestCase {
@Autowired static AnnotationConfigApplicationContext context;
	
	// if you are using xml based configuration
	
	
	@Autowired static MyCartDAO myCartDAO;

	@Autowired
	static MyCart myCart;
	
	//the above object need to initialize
	//this method is going to execute before calling any one of test case
	//and will execute once
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		myCartDAO=(MyCartDAO) context.getBean("myCartDAO");
		
		//get the user from context
		myCart=(MyCart) context.getBean("myCart");
		
	}
	
	@Test
	public void createCategoryTestCase(){
	
		myCart.setId("1");
		myCart.setProduct_name("Iphone 7");
		myCart.setPrice(70000);
		myCart.setStatus('Y');
		myCart.setUser_id("U101");
		myCart.setDate_added("2014-12-12");
		
		boolean flag=myCartDAO.save(myCart);
		
		assertEquals("createUserTestCase",true,flag);
		
			}

}
*/