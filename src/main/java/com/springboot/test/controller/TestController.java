package com.springboot.test.controller;

import com.springboot.test.dao.CityDao;
import com.springboot.test.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jerry on 16/8/1.
 */
@Controller
@RequestMapping("/v1")
public class TestController {

    @RequestMapping(value = "/test01", method = RequestMethod.GET)
    @ResponseBody
    public Object test01(){
        City city = new City();
        city.setName("jerry");
        city.setCountry("china");
        return city;
    }

    @Autowired
    private CityDao cityDao;

    @RequestMapping(value = "/save",method = RequestMethod.PUT)
    @ResponseBody
    public Object save(){
        City city = new City();
        city.setName("saver01");
        city.setCountry("china");
        cityDao.save(city);

        return "succ";
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public Object get(){
        City city = cityDao.findById(1l);
        return city;
    }
}
