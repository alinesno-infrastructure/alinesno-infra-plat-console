package com.alinesno.infra.plat.console.adapter;

import com.dtflys.forest.annotation.BaseRequest;

/**
 * 平台消费者基类
 */
@BaseRequest(
        baseURL = "#{alinesno.infra.gateway.host}/smart-brain" ,
        connectTimeout = 30*1000
)
public interface SmartBrainConsumer {

}
