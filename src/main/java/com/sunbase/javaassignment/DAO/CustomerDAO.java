package com.sunbase.javaassignment.DAO;

import com.sunbase.javaassignment.Customer;

import java.util.List;

public interface CustomerDAO {
    public boolean addCustomer(Customer c);
    public boolean editCustomer(Customer c);
    public boolean deleteCustomer(String  uuid);
    public List<Customer> getCustomerList();
    public Customer getCustomerByUuid(String uuid);
}
