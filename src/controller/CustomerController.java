package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Customer;
import service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject our customer service
	//Spring will scan for a component that implements CustomerService interface 
	@Autowired
	private CustomerService customerService; 
			
	@GetMapping(value = "/list")
	public String listcustomers(Model theModel){		
		//get customer from service	
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customer to the model in form <Name>:<Value>
		theModel.addAttribute("customers", theCustomers );
						
		return "list-customers";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String savecustomer(@ModelAttribute("customer") Customer theCustomer){
		//save the cutomer using our service
		customerService.saveCustomer(theCustomer);
		
		return "redirect:/customer/list";
	}
	
}
