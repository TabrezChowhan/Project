package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Supplier;

public class SupplierTestCase {

	@Autowired static AnnotationConfigApplicationContext context;
	
	@Autowired static SupplierDAO supplierDAO;
	
	@Autowired static Supplier supplier;
	
	@BeforeClass
	public static void initialization(){
		
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
	}
	
	//@Test
	public void createSupplierTestCase(){
		supplier.setId("S666");
		supplier.setName("Sun System");
		supplier.setAddress("Chenai");
		
		boolean flag = supplierDAO.save(supplier);
		assertEquals("createSupplierTestCase", true, flag);
	}
	
	//@Test
	public void updateSupplierTestCase(){
		
		supplier.setId("S222");
		supplier.setName("Techsoft");
		supplier.setAddress("Delhi");
		
		boolean flag = supplierDAO.update(supplier);
		assertEquals("updateSupplierTestCase",true,flag);
	}
	
	//@Test
	public void deleteByIdTestCase(){
		
		boolean flag = supplierDAO.delete("S444");
		assertEquals("deleteByIdTestCase", true, flag);
	}
		
	//@Test
	public void getSupplierByIdTestCase(){
		
		supplier = supplierDAO.getSupplierById("S333");
		assertEquals(supplier.getClass().getName(), supplier.getClass().getName());
	}
	
	//@Test
	public void getSupplierByNameTestCase(){
		supplier = supplierDAO.getSupplierByName("Sun System");
		assertEquals(supplier.getClass().getName(), supplier.getClass().getName());
	}
	
	@Test
	public void getAllSupplierTestCase(){
		int actualsize = supplierDAO.list().size();
		assertEquals(2, actualsize);
	}
}











