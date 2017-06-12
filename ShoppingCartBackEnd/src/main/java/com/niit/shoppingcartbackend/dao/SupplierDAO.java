package com.niit.shoppingcartbackend.dao;

import java.util.List;

import com.niit.shoppingcartbackend.domain.Supplier;

public interface SupplierDAO {
	
public boolean save(Supplier supplier);
	
	public boolean update(Supplier supplier);
	
	public boolean delete(String id);
	
	public List<Supplier> list(); 
	
	public Supplier getSupplierById(String id);

	public Supplier getSupplierByName(String name);

}
