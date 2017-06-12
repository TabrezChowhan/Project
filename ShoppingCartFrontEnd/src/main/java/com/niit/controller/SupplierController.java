package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.niit.shoppingcartbackend.dao.ProductDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.domain.Product;
import com.niit.shoppingcartbackend.domain.Supplier;

@Controller
public class SupplierController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
@RequestMapping("/manage_supplier_add")
 public ModelAndView createSupplier(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("address") String address,RedirectAttributes redirectAttributes){
	supplier.setId(id);
	supplier.setName(name);
	supplier.setAddress(address);
	ModelAndView mv=new ModelAndView("redirect:/manageSupplier");
	
	if(supplierDAO.getSupplierById(id)!=null){
		redirectAttributes.addFlashAttribute("message", "Supplier already with the existing id"+id);
		return mv;
	}
	else{
		supplierDAO.save(supplier);
		redirectAttributes.addFlashAttribute("message","Supplier Added Successfully");
	}
	session.setAttribute("supplierList", supplierDAO.list());
	session.setAttribute("supplier", supplier);
	return mv;
}

@PostMapping("/manage_supplier_update")
public ModelAndView updateSupplier(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("address") String address,RedirectAttributes redirectAttributes){
	supplier.setId(id);;
	supplier.setName(name);
	supplier.setAddress(address);
	ModelAndView mv= new ModelAndView("redirect:/manageSupplier");
	
	if(supplierDAO.getSupplierById(id)==null){
		redirectAttributes.addFlashAttribute("message", "Supplier does not exist with the id"+id);
		return mv;
	}
	else{
		supplierDAO.update(supplier);
		redirectAttributes.addFlashAttribute("message", "Supplier Updated Successfully");
	}
	session.setAttribute("selectedSupplier",new Supplier());
	return mv;
}

@RequestMapping("/manage_supplier_edit/{id}")
public ModelAndView editCategory(@PathVariable("id") String id)
{
	//log.debug("Starting of method Edit Categories");
	
	//log.debug("Going to Edit the Category : "+id);
	
	supplier = supplierDAO.getSupplierById(id);
	
	//selected category details stored in another instance
	//in ModelAndView instance
	
	ModelAndView mv = new ModelAndView("redirect:/manageSupplier");
	
mv.addObject("selectedSupplier",supplier);
	session.setAttribute("selectedSupplier", supplier);
	
	
	//log.debug("Ending of the method Edit Category");
	
	return mv;
}


@RequestMapping("/manage_supplier_delete/{id}")
public ModelAndView deleteCategory(@PathVariable("id") String id, RedirectAttributes redirectAttributes){
	
	//log.debug("Staring of the method delete Category");
	
	//log.debug("You are going to delete "+id);
	
	ModelAndView mv = new ModelAndView("redirect:/manageSupplier");
	//mv.addObject("isAdmin","true");
	//mv.addObject("isAdminClickedCategories","true");
	
	// check whether the product are there for this category or not
	
	int size = productDAO.getAllProductsBySupplierId(id).size();
	if(size !=0)
	{
		//log.debug("Few Product is under this Category, You can not delete");
		//mv.addObject("message","There are "+size+" Product is under this Category "+id+" You can not delete");
		redirectAttributes.addFlashAttribute("message","There are "+size+" Product is under this Category "+id+" You can not delete");
		return mv;	
	}
	if (supplierDAO.delete(id)==true) 
	{
		//mv.addObject("message"," Successfully deleted the category");
		redirectAttributes.addFlashAttribute("message"," Successfully deleted the category");
	}
	else 	
	{
		//mv.addObject("message","Not able to Delete the Category");
		redirectAttributes.addFlashAttribute("message","Not able to Delete the Category");
	}
	
	//session.setAttribute("categoryList", categoryDAO.list());
	//session.setAttribute("category", category);
	
	//log.debug("Ending of the method delete Category");
	
	return mv;
}
}