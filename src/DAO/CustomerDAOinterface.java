package DAO;

import java.util.List;
import entity.Customer;

public interface CustomerDAOinterface {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
