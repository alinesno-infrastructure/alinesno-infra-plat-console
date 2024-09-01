package com.alinesno.infra.plat.console.adapter.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AgentChannelResponse {

    @JSONField(name = "recommend")
    @JsonProperty("recommend")
    private List<AgentChannelDto> recommendChannels;

    @JSONField(name = "public")
    @JsonProperty("public")
    private List<AgentChannelDto> specificChannels;

    public AgentChannelResponse(List<AgentChannelDto> recommendChannels, List<AgentChannelDto> specificChannels) {
        this.recommendChannels = recommendChannels;
        this.specificChannels = specificChannels;
    }
}