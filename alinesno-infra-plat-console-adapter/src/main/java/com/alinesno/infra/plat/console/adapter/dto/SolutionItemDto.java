package com.alinesno.infra.plat.console.adapter.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SolutionItemDto {

    private String title;  // 方案标题
    private String content;  // 方案内容
    private String link;  // 方案链接
    private Date addDate ;  // 添加日期

}
