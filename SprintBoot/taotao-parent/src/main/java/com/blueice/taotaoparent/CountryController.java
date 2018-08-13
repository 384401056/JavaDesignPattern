package com.blueice.taotaoparent;

import com.blueice.taotaoparent.Service.CountryServiceJPA;
import com.blueice.taotaoparent.bean.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    CountryServiceJPA countryServiceJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Country> getCustomersJpa() {
        return countryServiceJPA.getCountys();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Country> getCountryById(@PathVariable("id") int id){
        return countryServiceJPA.getCounty(id);
    }

}
