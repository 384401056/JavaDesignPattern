package com.blueice.taotaoparent.Service;

import com.blueice.taotaoparent.bean.Country;
import com.blueice.taotaoparent.dao.ICountryJPADao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceJPA {

    @Autowired
    ICountryJPADao countryJPADao;

    public List<Country> getCountys() {
        return countryJPADao.findAll();
    }

    public Optional<Country> getCounty(int id) {
        return countryJPADao.findById(id);
    }
}
