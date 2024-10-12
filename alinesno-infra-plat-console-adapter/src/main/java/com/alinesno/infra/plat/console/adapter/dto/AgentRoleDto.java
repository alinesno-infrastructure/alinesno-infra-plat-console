package com.alinesno.infra.plat.console.adapter.dto;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 会话频道 DTO 模型
 * 用于封装会话频道的相关信息，如角色头像、名称、职责等
 */
@Data
@Accessors(chain = true)
public class AgentRoleDto {

    /**
     * 频道唯一标识符
     */
    private long id ;

    /**
     * 角色头像 URL
     */
    private String roleAvatar;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色职责描述
     */
    private String responsibilities;

    /**
     * 角色级别
     */
    private String roleLevel;

    /**
     * 角色相关链接，例如官网链接或文档链接
     */
    private String roleLink;

    /**
     * 显示顺序编号
     */
    private int orderNumber ;

}
