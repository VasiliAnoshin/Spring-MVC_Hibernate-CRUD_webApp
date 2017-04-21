package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import DAO.CustomerDAO;
import entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the DAO into Controller
	//Spring will scan for a component that implements DAO interface 
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listcustomers(Model theModel){		
		//get customer from the dao		
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		//add the customer to the model in form <Name>:<Value>
		theModel.addAttribute("customers", theCustomers );
						
		return "list-customers";
	}
}
