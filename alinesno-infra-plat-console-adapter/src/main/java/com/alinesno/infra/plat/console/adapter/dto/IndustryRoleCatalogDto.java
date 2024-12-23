package com.alinesno.infra.plat.console.adapter.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class IndustryRoleCatalogDto {

    private Long id ;

    private String icon;

    private String name ;

    private int orderNum ;

    private String description;

    private List<IndustryRoleDto> agents = new ArrayList<>();

}