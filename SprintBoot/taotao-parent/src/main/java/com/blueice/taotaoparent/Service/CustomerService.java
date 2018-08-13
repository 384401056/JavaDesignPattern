package com.blueice.taotaoparent.Service;

import com.blueice.taotaoparent.bean.Customer;
import com.blueice.taotaoparent.dao.ICustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ICustomerDAO customerDAO;

    public int updateCustomer(Customer customer){
        return customerDAO.update(customer);
    }

    public Customer findAccountById(int id) {
        return customerDAO.findCustomerById(id);
    }

    public List<Customer> findAccountList() {
        return customerDAO.findcustomerList();
    }
}
