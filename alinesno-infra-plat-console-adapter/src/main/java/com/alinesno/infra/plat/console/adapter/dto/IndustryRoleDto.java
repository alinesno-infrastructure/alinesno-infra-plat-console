package com.alinesno.infra.plat.console.adapter.dto;

import lombok.Data;

@Data
public class IndustryRoleDto {

    private Long id ;

    private String roleName; // 角色名称

    private String roleAvatar ; // 角色头像

    private Long industryCatalog ; // 所属行业

    private String responsibilities; // 角色职责描述

    private String skills; // 所需技能描述

    private String roleLevel; // 角色等级

    private String chatCount; // 会话次数
}