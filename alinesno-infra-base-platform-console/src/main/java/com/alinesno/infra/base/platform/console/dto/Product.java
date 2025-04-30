package com.alinesno.infra.base.platform.console.dto;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private List<SubProduct> subList;
    private String name;
    private String banner;
    private String id;

}
