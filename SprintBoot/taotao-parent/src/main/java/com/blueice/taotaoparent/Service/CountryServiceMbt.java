package com.blueice.taotaoparent.Service;

import com.blueice.taotaoparent.bean.Address;
import com.blueice.taotaoparent.dao.IAddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceMbt {
    @Autowired
    IAddressMapper addressMapper;

    public List<Address> getAddress(){
        return addressMapper.findAccountList();
    }

    public Address getAddressById(int id){
        return addressMapper.findAccount(id);
    }
}
