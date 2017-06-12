package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.User;

public interface CategoryDAO {
	
public boolean save(Category category);
	
	public boolean update(Category category);
	 
	public boolean delete(String id);
	
	public List<Category> list(); 
	
	public Category getCategoryById(String id);
	
	public Category getcategoryByName(String name);

}
