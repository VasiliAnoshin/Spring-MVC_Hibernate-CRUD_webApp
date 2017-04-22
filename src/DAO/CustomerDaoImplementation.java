package DAO;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Customer;

@Repository
public class CustomerDaoImplementation implements CustomerDAOinterface {
	//need to inject the session factory 
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
		//create a querry 
		Query<Customer>  theQuery = 
				curSession.createQuery("from Customer order by lastName" , Customer.class);
		//execute querry and get result list
		List<Customer> customers = theQuery.getResultList();
		//return the result 
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the current hibernate session
		Session curSession = sessionFactory.getCurrentSession();		
		//create a querry 
		curSession.saveOrUpdate(theCustomer);		
	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current hibernate session
		Session curSession = sessionFactory.getCurrentSession();
		//now retrieve/read from db using the primary key
		Customer theCustomer = curSession.get(Customer.class, theId);		
		return theCustomer;
	}

}
