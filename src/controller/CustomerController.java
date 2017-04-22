package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping(value = "/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerID") int theId, Model theModel){		
		//get the customer from the service
		Customer theCustomer = customerService.getCustomer(theId);
		//set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);
		//send over to our form
		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerID") int theId){
		//delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
}
