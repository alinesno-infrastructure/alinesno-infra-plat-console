package com.alinesno.infra.base.platform.enums;

import lombok.Getter;

@Getter
public enum ChannelType {

    // 频道类型
    PUBLIC_CHANNEL("9" , "公开频道"),  // 对外公开频道
    PERSONAL_PUBLIC_CHANNEL("1" , "个人公共频道"),  // 个人公共频道
    RECOMMEND_CHANNEL("3" , "推荐频道"),
    PRIVATE_CHANNEL("2" , "私有频道"); // 私有频道

    private final String value;
    private final String label;

    ChannelType(String value, String label) {
        this.value = value;
        this.label = label;
    }

}
