package com.springboot.test.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Jerry on 16/8/1.
 */
@Data
public class City implements Serializable {

    private Long id;

    private String name;

    private String state;

    private String country;

}