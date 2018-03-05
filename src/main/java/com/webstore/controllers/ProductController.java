package com.webstore.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webstore.domain.Product;
import com.webstore.exception.NoProductsFoundUnderCategoryException;
import com.webstore.service.ProductService;

@Controller
@EnableWebMvc

// Since /market is written on class level it will be needed by every URL
@RequestMapping("/market")
public class ProductController {
	// private static final Logger logger =
	// Logger.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping()
	public String defaultM(Model model, RedirectAttributes redirectAttributes) {
		model.addAttribute("greeting", "redirect!!---!!");
		// Setting them as Flashattributes for them to be still available on the model
		// after the request is redirected to other page
		
		redirectAttributes.addFlashAttribute("greeting", "Welcome to Web Store!");
		return "redirect:market/welcome/greeting";
	}
	
	@RequestMapping("/welcome/greeting")
	public String greeting() {
		return "welcome";
	}
	
	@RequestMapping("/products")
	public ModelAndView list(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("products", productService.getAllProducts());
		modelAndView.setViewName("products");
		return modelAndView;
	}
	
	// @PathVariable annotation checks for the variable category in the URL and
	// assigns it to String productCategory as mentioned
	// Here we can also use a map to store all the path variables if there are more
	// than one.
	// also requires mvc annotation tag in mvs dispatcher-servlet.xml
	@RequestMapping("/products/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		System.out.println("checking product category from path variale " + productCategory);
		List<Product> products = productService.getProductsByCategory(productCategory);
		if (products == null || products.isEmpty()) {
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}
	
	@RequestMapping("/product")
	public ModelAndView getProductById(@RequestParam("id") String productId, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("product", productService.getProductById(productId));
		modelAndView.setViewName("product");
		return modelAndView;
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Locale locale, Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	// This is a post method
	// The result is binded to the newProduct and you don't even have to worry about
	// the type of variables in the product bean
	@RequestMapping(value = "/products/addTheProduct", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded, BindingResult result) {
		System.out.println("Enters here addTheProduct");
		if (result.hasErrors()) {
			System.out.println("ERRORS FOUND IN REQUEST");
		}
		
		if (result.getSuppressedFields().length > 0) {
			throw new RuntimeException("Attempting to bind disallowed fields: " + StringUtils.arrayToCommaDelimitedString(result.getSuppressedFields()));
		}
		productService.addProduct(productToBeAdded);
		return "redirect:/market/products";
	}
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("name", "unitPrice", "description", "manufacturer", "category", "condition", "language", "image", "siteLanguage");
	}
	
	// By specifying model attribute annotation at the top, every jsp/model will get
	// the attributes added in this model.
	// Spring MVC always makes call to this method first
	@ModelAttribute
	public void addingCommonObjectsToTheModel(Model model) {
		model.addAttribute("globalAttribute", "Tanay");
	}
	
	/*
	 * @RequestMapping("/update/stock") public ModelAndView updateStock(Model model)
	 * { ModelAndView modelAndView = new ModelAndView();
	 * productService.updateAllStock(); modelAndView.setViewName("products"); return
	 * modelAndView;
	 * 
	 * }
	 */
}