package com.alinesno.infra.base.platform.console;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 这是一个用于存储云反馈的实体类
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class FeedbackDto implements Serializable {

    private String typeCode; // 建议类型
    private long grade ; // 评分
    private String title; // 标题
    private String problemDesc; // 建议内容
    private String proposedSolution;
    private String productItemId;

    private long accountId; // 用户ID
    private long orgId ; // 机构ID
}
