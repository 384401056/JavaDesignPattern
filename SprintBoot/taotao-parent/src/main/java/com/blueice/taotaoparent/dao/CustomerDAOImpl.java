package com.blueice.taotaoparent.dao;

import com.blueice.taotaoparent.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Customer数据访问的实现类,使用sql语句查询数据库
 */
@Repository //用于标注数据访问组件
public class CustomerDAOImpl implements ICustomerDAO {


    @Autowired
    private JdbcTemplate jdbcTemplate;//jdbc模板

    @Override
    public int add(Customer customer) {
        return 0;
    }

    @Override
    public int update(Customer customer) {
        return jdbcTemplate.update("UPDATE customer SET first_name=? ,last_name=? WHERE customer_id=?",
                customer.getFirst_name(),customer.getLast_name(),customer.getCustomer_id());
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public Customer findCustomerById(int id) {
        List<Customer> list = jdbcTemplate.query("select * from customer where customer_id = ?", new Object[]{id}, new BeanPropertyRowMapper(Customer.class));
        if(list!=null && list.size()>0){
            return list.get(0);
        }else{
            return null;
        }
    }

    @Override
    public List<Customer> findcustomerList() {
        List<Customer> list = jdbcTemplate.query("select * from customer", new Object[]{}, new BeanPropertyRowMapper(Customer.class));
        if(list!=null && list.size()>0){
            return list;
        }else{
            return null;
        }
    }
}
