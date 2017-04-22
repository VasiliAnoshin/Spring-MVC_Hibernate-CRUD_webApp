package service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import DAO.CustomerDAOinterface;
import entity.Customer;

@Service
public class customerServiceImpl implements CustomerService {
	
	//need to inject customer dao
	@Autowired
	private CustomerDAOinterface customerDaO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDaO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDaO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDaO.getCustomer(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDaO.deleteCustomer(theId);
	}

}
