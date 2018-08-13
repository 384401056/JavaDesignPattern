package com.blueice.taotaoparent;

import com.blueice.taotaoparent.Service.CountryServiceMbt;
import com.blueice.taotaoparent.bean.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    CountryServiceMbt countryServiceMbt;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Address> getAddressList(){
        return countryServiceMbt.getAddress();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable("id") int id){
        return  countryServiceMbt.getAddressById(id);
    }
}
