package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Category;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;
import com.niit.util.FileUtil;
import com.niit.util.Util;

@Controller
public class ProductController {
	
	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	//@Autowired HttpSession session;
	
	@Autowired Product product;
	
	@Autowired ProductDAO productDAO;
	
	@Autowired Category category;
	
	@Autowired CategoryDAO categoryDAO;
	
	@Autowired Supplier supplier;
	
	@Autowired SupplierDAO supplierDAO;
	
	@Autowired HttpSession session;
	
		//Actually we have to keep this path in a property file
		//private String path = "G:\MyProject\ShoppingCartFrontEnd\src\main\webapp\resources\images";
		
		//private String path = "resources/imges/";
	
	// setting path to store images
	 // private String path   ="G://MyProject//ShoppingCartFrontEnd//src//main/webapp//resources//images";
	  private String path   = "E:/Workspace/ShoppingCartFrontEnd/src/main/webapp/resources/image";
		
	  // get the path where you downloaded tomcat
	  //E:\Software\Tomcat\apache-tomcat-9.0.0.M18-windows-x64
	  //private  String path =System.getProperty("catalina.home");
	  
	 /*@RequestMapping("/searchProduct/{search_string}")
		public ModelAndView getAllProductBySearchString(@PathVariable("search_string")
			String search_string)
		{
		  List<Product> products=	 productDAO.getSimilarProducts(search_string);
		  ModelAndView mv= new ModelAndView("/Home");
		  
		  if(products.isEmpty())
		  {
			  mv.addObject("msg", "No products are available with the search text :" +search_string );
		  }
		  else
		  {
			  mv.addObject("productList", products);
		  }
	  
		  return mv;
	  
		}*/
	
	  @RequestMapping(value = "/manageProducts", method = RequestMethod.GET)
	  public String manageProducts(Model model) {
			log.debug("Starting of the method manageProducts");
			model.addAttribute("isAdminClickedProducts", "true");
			model.addAttribute("isAdmin", "true");
			model.addAttribute("product", product);
			model.addAttribute("productList", productDAO.list());
			model.addAttribute("supplier", supplier);
			model.addAttribute("supplierList", supplierDAO.list());
			model.addAttribute("category", category);
			model.addAttribute("categoryList", categoryDAO.list());
			session.setAttribute("isUserLoggedIn", "false");
			log.debug("Ending of the method manageProducts");
			return "Home";

		}
		  // For add and Update Product Both
	  
	  @RequestMapping(value="/manage_product_add", method=RequestMethod.POST)
	  public String addProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file, Model model)
	  {
		  log.debug("Starting of method addProduct");
			Category category = categoryDAO.getcategoryByName(product.getCategory().getName());
			Supplier supplier = supplierDAO.getSupplierByName(product.getSupplier().getName());

			product.setCategory(category);
			product.setCategory_id(category.getId());
			
			product.setSupplier(supplier);
			product.setSupplier_id(supplier.getId());
			
			product.setId(Util.removeComman(product.getId()));
			productDAO.saveOrUpdate(product);

			FileUtil.upload(path, file, product.getId() + ".jpeg");

			model.addAttribute("isAdminClickedProducts", "true");
			model.addAttribute("isAdmin", "true");

			model.addAttribute("productList", this.productDAO.list());
			model.addAttribute("product", new Product());
			model.addAttribute("categoryList", this.categoryDAO.list());
			model.addAttribute("category", new Category());
			log.debug("Ending of the method add Product");
			return "Home";
		}

	  
	  // update the product
	/*  @RequestMapping(value="manage_product_update", method=RequestMethod.POST)
	  public String updateProduct(@ModelAttribute("product") Product product, @RequestParam("image") MultipartFile file, Model model)
	  {
		  log.debug("Starting of the method update Product");
		  Category category = categoryDAO.getCategoryById(product.getCategory().getName());
		  
		  Supplier supplier = supplierDAO.getSupplierById(product.getSupplier().getName());
		  
		  
		  product.setCategory(category);
		  product.setSupplier(supplier);
		  
		  product.setCategory_id(category.getId());
		  product.setSupplier_id(supplier.getId());
		  
		  FileUtil.upload(path, file, product.getId() + ".jpg");
		  
		  productDAO.update(product);
		  
		  return "Home";
	  }*/

	  // Delete Product
	  @RequestMapping("/manage_product_delete/{id}")
	  public String deleteProduct(@PathVariable("id") String id,ModelMap model)
	  {
		  log.debug("Starting of the method deleteProduct");
		  
		  try
		  {
			  productDAO.delete(id);
			  model.addAttribute("message","Successfully Deleted Product");
		  }
		  catch (Exception e) {
			model.addAttribute("message",e.getMessage());
			e.printStackTrace();
		}
		  
		  log.debug("Ending of the Method deleteProduct");
		  
		  return "redirect:/manageProducts";
	  }
	
	  // Edit Product
	  
	  @RequestMapping("/manage_product_edit/{id}")
	  
	  public String editProduct(@PathVariable("id") String id, Model model) {
			log.debug("Starting of the method editProduct");
			product = productDAO.getProductById(id);
			model.addAttribute("product", product);
			log.debug("Ending of the method editProduct");
			return "redirect:/manageProducts";
		}

	
	  // get selected product
	  
	  @RequestMapping("/manage_product_get/{id}")
	  public ModelAndView getSelectedProduct(@PathVariable("id") String id, RedirectAttributes redirectAttributes)
	  {
		  
		  log.debug("Starting of method getSelectedProduct");
		  
		  ModelAndView mv =  new ModelAndView("redirect:/");
		   
		  redirectAttributes.addFlashAttribute("selectedProduct",productDAO.getProductById(id));
		  
		  log.debug("Ending of the method getSelectedproduct");
		  
		  return mv;
	  }
	  
	  
	
}




