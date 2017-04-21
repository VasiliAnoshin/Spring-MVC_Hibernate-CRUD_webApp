package DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Customer;

public interface CustomerDAOinterface {
	public List<Customer> getCustomers();
}
