package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.UserDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;

public class CategoryDAOTestCase {

@Autowired static AnnotationConfigApplicationContext context;
	
	// if you are using xml based configuration
	
	
	@Autowired static CategoryDAO categoryDAO;

	@Autowired static Category category;
	
	//the above object need to initialize
	//this method is going to execute before calling any one of test case
	//and will execute once
	@BeforeClass
	public static void initialize(){
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		//get the userDAO from context
		categoryDAO=(CategoryDAO) context.getBean("categoryDAO");
		
		//get the user from context
		category=(Category) context.getBean("category");
		
	}
	
	//@Test
	public void createCategoryTestCase(){
	
		category.setId("C101");
		category.setName("Apple");
		category.setDescription("Iphone 7");
		
		
		boolean flag=categoryDAO.save(category);
		
		assertEquals("createUserTestCase",true,flag);
		
			}
	//@Test
	public void updateCategoryTestCase(){
		
		category.setId("C111");
		category.setName("Xiomi");
		category.setDescription("Redmi note 3 plus");
		
		
		boolean flag=categoryDAO.update(category);
		
		assertEquals("updateCategoryTestCase",true,flag);
		
			}	

	//@Test
	public void getAllCategory(){
		List<Category> categoryList= categoryDAO.list();
		
		assertEquals(1, categoryList.size());
	}
	
}
