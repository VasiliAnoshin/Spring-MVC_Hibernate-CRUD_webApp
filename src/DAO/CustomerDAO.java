package DAO;

import java.util.List;

import org.springframework.stereotype.Service;

import entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();
}
