package service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.CustomerDAOinterface;
import entity.Customer;

public class customerServiceImpl implements CustomerService {
	
	//need to inject customer dao
	@Autowired
	private CustomerDAOinterface customerDaO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDaO.getCustomers();
	}

}
