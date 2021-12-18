package com.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDao;
import com.dao.IssueDao;
import com.dao.LoginDao;
import com.exceptions.CustomerNotFoundException;
import com.exceptions.DuplicateCustomerException;
import com.exceptions.InvalidCredintialException;
import com.exceptions.IssueNotFoundException;

import com.model.Customer;
import com.model.Issue;
import com.model.Login;

@Service
public class CustomerService {
	@Autowired
	CustomerDao repo;

	public Customer registerCustomer(Customer customer) throws Throwable {
		Supplier s1 = () -> new DuplicateCustomerException("Already  exist in the database");
		repo.save(customer);
		return customer;
	}
	public List<Customer> getAllCustomers(){
		List<Customer> c=repo.findAll();
		return c;
		}
	public Customer modifyCustomer(Customer customer) {
		int customerId = customer.getCustomerId();
		Optional<Customer> optional = repo.findById(customerId);
		if (optional.isPresent()) {
			Customer o = optional.get();
			o.setFirstName(customer.getFirstName());
			o.setLastName(customer.getLastName());
			o.setCustomerId(customer.getCustomerId());
			o.setEmail(customer.getEmail());
			o.setMobile(customer.getMobile());
			o.setCity(customer.getCity());
			return repo.save(o);
		}
		return null;
	}
	//delete customer
	public Customer removeCustomer(int customerId) {
		Customer c = repo.findById(customerId).get();
		repo.deleteById(customerId);
		return c;
	}
	@Autowired
	IssueDao repo1;

	public List<Issue> viewAllIssues() {
		List<Issue> lc1 = repo1.findAll();
		return lc1;
	}

	public Issue viewIssueById(int issueId) throws Throwable {
		Supplier s1 = () -> new IssueNotFoundException("Issue Does not exist in the database");
		Issue c = repo1.findById(issueId).orElseThrow(s1);
		return c;
	}

	public Issue reopenIssue(int issueId) throws Throwable {
		Supplier s1 = () -> new IssueNotFoundException("Issue Does not exist in the database");
		Issue c = repo1.findById(issueId).orElseThrow(s1);
		return c;
	}
	

	@Autowired
	LoginDao repo2;

	public Login login(Login userId) throws InvalidCredintialException

	{
		Login l=repo2.save(userId);
		;return l;
	}

	public Login changepassword(Login login) {
        int userId=login.getUserId();
        Optional<Login> optional=repo2.findById(userId);
        if(optional.isPresent()) {
            Login d=optional.get();
            d.setUsername(login.getUsername());
            d.setUserId(login.getUserId());
            d.setPassword(login.getPassword());
            return repo2.save(d);    
        }
        return null;
        
    }
    public Login forgotPassword(int userId) {
    Login e=repo2.getById(userId);
        return e;
    }

 

    }