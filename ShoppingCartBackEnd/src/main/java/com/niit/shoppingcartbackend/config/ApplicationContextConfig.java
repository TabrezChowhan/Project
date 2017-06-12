package com.niit.shoppingcartbackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.MyCart;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;
import com.niit.shoppingcartbackend.domain.User;


@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class ApplicationContextConfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		
		return dataSource;
	}

	
	private Properties getHibernateProperties() {
		System.out.println("Starting of the method getHibernateProperties");
		Properties properties = new Properties();
		//properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("Hibernate Properties Implementation");

		return properties;
	}

	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) 
	{
	System.out.println("Starting of the method getSessionFactory");
	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClasses(User.class);
	sessionBuilder.addAnnotatedClasses(Category.class);
	sessionBuilder.addAnnotatedClasses(Supplier.class);
	sessionBuilder.addAnnotatedClasses(Product.class);
	sessionBuilder.addAnnotatedClasses(MyCart.class);
	//sessionBuilder.scanPackages("com.niit.shoppingcartbackend.domain");
	return sessionBuilder.buildSessionFactory();
	}

	@Autowired
	@Bean(name= "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
	System.out.println("Starting of the method getTransactionManager");
	HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
	System.out.println("Transaction Implementation");
	return transactionManager;
	}


	}
