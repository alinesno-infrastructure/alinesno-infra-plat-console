package com.alinesno.infra.plat.console.adapter.dto;

import com.alinesno.infra.common.facade.base.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 会话频道
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AgentChannelDto extends BaseDto {

    private String name; // Channel name
    private String description; // Channel description
    private String type; // Channel type (e.g., public, private)
    private String status; // Channel status (e.g., active, inactive)
    private long creatorId; // Creator ID
    private String creatorName;// Creator name
    private String image;

}