package com.blueice.taotaoparent.dao;

import com.blueice.taotaoparent.bean.Customer;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Customer数据访问对象
 */
public interface ICustomerDAO {

    int add(Customer customer);

    int update(Customer customer);

    int delete(int id);

    Customer findCustomerById(int id);

    List<Customer> findcustomerList();
}
