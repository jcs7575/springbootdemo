package com.springboot.test.dao;

import com.springboot.test.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by Jerry on 16/8/16.
 */
@Mapper
public interface CityDao {

    int save(City city);

    City findById(Long id);
}
