package com.blueice.taotaoparent.dao;

import com.blueice.taotaoparent.bean.Address;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface IAddressMapper {

    @Select("select address_id, address, address2, district, city_id, postal_code, phone, last_update from address where address_id = #{id}")
    Address findAccount(@Param("id") int id);

    @Select("select address_id, address, address2, district, city_id, postal_code, phone, last_update from address")
    List<Address> findAccountList();
}
