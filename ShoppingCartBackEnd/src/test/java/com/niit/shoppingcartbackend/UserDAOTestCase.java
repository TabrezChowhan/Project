package com.niit.shoppingcartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.User;

public class UserDAOTestCase {

	
	@Autowired static AnnotationConfigApplicationContext context;
	
	// if you are using xml based configuration
	
	
	@Autowired static UserDAO userDAO;

	@Autowired static User user;
	
	//the above object need to initialize
	//this method is going to execute before calling any one of test case
	//and will execute once
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		userDAO=(UserDAO) context.getBean("userDAO");
		
		//get the user from context
		user=(User) context.getBean("user");
		
	}
	
	@Test
	public void createUserTestCase(){
	
		user.setId("U102");
		user.setName("haider");
		user.setPassword("haider");
		user.setContact("123456789");
		user.setRole("admin");
		
		boolean flag=userDAO.save(user);
		
		assertEquals("createUserTestCase",true,flag);
		
			}	
	//@Test
	public void updateUserTestCase(){
	
		user.setId("SBK");
		user.setName("SBK1");
		user.setPassword("abcd");
		user.setContact("12345");
		user.setRole("Role_User");
		
		boolean flag = userDAO.update(user);
	
		
		//this assertEquals methods 
		//error -- if there is any runtime errors - Red Mark
		//success -- if expected and actual is same - Green Mark
		//fail -- if expected and actual is different - Blue Mark
		assertEquals("updateUserTestCase",true,flag);
	
}
	//@Test
	public void validateUserTestCase()
	{
		boolean flag=userDAO.validate("chowhan","tabrez@123");
		
		assertEquals("Validation",true,flag);
		
	}
	
	//@Test
	public void getAllUserTestCase()
	{
		int actualsize=userDAO.list().size();
		
		assertEquals(5,actualsize);
		System.out.println(user.getId());
	
	}
}