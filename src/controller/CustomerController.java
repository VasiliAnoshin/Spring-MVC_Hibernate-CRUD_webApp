package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.CustomerDAOinterface;
import entity.Customer;
import service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject our customer service
	//Spring will scan for a component that implements CustomerService interface 
	@Autowired
	private CustomerService customerService; 
			
	@GetMapping("/list")
	public String listcustomers(Model theModel){		
		//get customer from the dao		
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customer to the model in form <Name>:<Value>
		theModel.addAttribute("customers", theCustomers );
						
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		return "customer-form";
	}
}
