package com.alinesno.infra.base.platform.console.dto;

import lombok.Data;

/**
 * 团队主题
 */
@Data
public class TeamThemeDto {

    private String logo ;   // 平台logo
    private String name ;   // 平台主题名称
    private int viewSet ; // 视图配置

}
