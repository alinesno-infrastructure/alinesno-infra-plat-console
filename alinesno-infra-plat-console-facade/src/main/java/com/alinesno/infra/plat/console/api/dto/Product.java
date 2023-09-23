package com.alinesno.infra.plat.console.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class Product {

    private List<SubProduct> subList;
    private String name;
    private String banner;
    private String id;

}
