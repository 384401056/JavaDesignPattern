package com.blueice.taotaoparent.dao;
import com.blueice.taotaoparent.bean.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICountryJPADao extends JpaRepository<Country, Integer> {
}
