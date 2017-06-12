package com.niit.shoppingcartbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.domain.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	//write user defined constructor with one parameter. i.e sessionFactory
	public CategoryDAOImpl(SessionFactory sessionFactory){
		
		this.sessionFactory=sessionFactory;
	}
		
	public boolean save(Category category) {
		try
		{
		sessionFactory.getCurrentSession().save(category);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	
	public boolean update(Category category) {
		try
		{
		sessionFactory.getCurrentSession().update(category);
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean delete(String id) {
		try
		{
		sessionFactory.getCurrentSession().delete(getCategoryById(id));
		}catch (Exception e) {
			//if any excpetion comes during execute of try block, catch will excute
			e.printStackTrace();
			return false;
		}
		return true;
	}


	
	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}


	
	public Category getCategoryById(String id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class,id);
				}

	

	
	public Category getcategoryByName(String name) {
/*		Query query=sessionFactory.getCurrentSession().createQuery("from category where name=?");
		query.setString(0, name);
		return (Category) query.uniqueResult();*/
		return (Category) sessionFactory.getCurrentSession().createQuery("from Category where name=?").setString(0, name).uniqueResult();
	}

	
	
}