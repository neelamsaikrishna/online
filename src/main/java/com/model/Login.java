package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import com.model.Customer;
import com.model.Operator;


@Data
@Entity
public class Login{
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String username;

	@NotEmpty(message = "Please enter your password")
	private String password;
	
	//private String role;
	
	@JsonIgnore
	private boolean isLoggedIn = false;
	
	@JsonIgnore
	@OneToOne(mappedBy="login")
	private Customer customer;
	private Operator operator;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}*/

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

	public  Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this. operator =  operator;
	}
	
	public  Customer getCustomer() {
		return  customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + userId + ", email=" + username + ", password=" + password + ", isLoggedIn=" + isLoggedIn + ", customer=" + customer + " operator=" + operator+"]";
	}
	
	
	
		
}