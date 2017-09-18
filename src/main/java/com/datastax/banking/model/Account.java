package com.datastax.banking.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "bank", name = "account")
public class Account {
	
	@PartitionKey
	@Column(name="customer_id")
	private String customerId;

	@ClusteringColumn
	@Column(name="account_no")
	private String accountNo;
	
	@Column(name="account_type")
	private String accountType;

	private String account_origin_system;
	private String account_status;
	private String address_line1;
	private String address_line2;
	private String address_type;
	private String city;
	private String country_code;
	private String country_name;
	private String created_by;
	private Date created_datetime;
	@Column(name="customer_nbr")
	private String customerNbr;
	private String date_of_birth;
	private String first_name;
	private String full_name;
	private String government_id;
	private String government_id_type;
	private String last_name;
	private Date last_updated;
	private String last_updated_by;
	private String middle_name;
	private List<Phone> phone_numbers;
	private String prefix;
	private String state_abbreviation;
	private String zipcode;
	private String zipcode4;

	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getCustomerNbr() { return customerNbr; }
	public void setCustomerNbr(String customerNbr) { this.customerNbr = customerNbr; }

	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public void addPhone (String phone_number,String phone_type) {
		Phone phone = new Phone();
		phone.setPhone_number(phone_number);
		phone.setPhone_type(phone_type);
		this.phone_numbers.add(phone);
	}



	public String getFirst_name() {
		return first_name;
	}
	 public void defineAllCustomerColumns(Customer customer) {
		this.customerNbr = customer.getcustomer_nbr();
		this.customerId = customer.getCustomerId();
		this.phone_numbers = customer.getPhones();
		this.first_name = customer.getFirstName();
		this.last_name = customer.getLast_name();
	}

	public void setFirst_name(String first) {
		this.first_name = first;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
}

