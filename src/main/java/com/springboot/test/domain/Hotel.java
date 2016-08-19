package com.springboot.test.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Jerry on 16/8/1.
 */
@Data
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long city;

    private String name;

    private String address;

    private String zip;

}
