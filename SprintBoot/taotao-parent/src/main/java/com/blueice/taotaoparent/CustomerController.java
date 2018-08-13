package com.blueice.taotaoparent;

import com.blueice.taotaoparent.Service.CustomerService;
import com.blueice.taotaoparent.Service.CountryServiceJPA;
import com.blueice.taotaoparent.bean.Country;
import com.blueice.taotaoparent.bean.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") int id){
        return customerService.findAccountById(id);
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Customer> getCustomers(){
        return customerService.findAccountList();
    }

    /**
     * PUT X-WWW-FORM-URLENCODED形式的提交。
     * @param id
     * @param first_name
     * @param last_name
     * @return
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateCustomer(
            @PathVariable("id") int id,//url上传递过来的参数
            @RequestParam(value = "first_name" ,required = true)String first_name,//请求体中的参数。
            @RequestParam(value = "last_name" ,required = true)String last_name){
        Customer customer=new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setCustomer_id(id);
        int t=customerService.updateCustomer(customer);
        if(t==1){
            return "OK";
        }else {
            return "fail";
        }
    }

    /**
     * post 表单式提交
     * @param id
     * @param request
     * @return
     * 也可以直接把表单的参数写在Controller相应的方法的形参中
     */
    @RequestMapping(value = "/post_update/{id}", method = RequestMethod.POST)
    public String postCustomer(
            @PathVariable("id") int id,HttpServletRequest request){
        Customer customer=new Customer();
        customer.setFirst_name(request.getParameter("first_name"));
        customer.setLast_name(request.getParameter("last_name"));
        customer.setCustomer_id(id);
        int t=customerService.updateCustomer(customer);
        if(t==1){
            return "OK";
        }else {
            return "fail";
        }
    }

}
