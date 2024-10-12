package com.alinesno.infra.plat.console.adapter;

import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.plat.console.adapter.dto.AgentChannelDto;
import com.alinesno.infra.plat.console.adapter.dto.IndustryRoleCatalogDto;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;

import java.util.List;

/**
 * 平台消费者基类
 */
@BaseRequest(
        baseURL = "#{alinesno.infra.gateway.host}/smart-brain" ,
        connectTimeout = 30*1000
)
public interface SmartBrainConsumer {

    /**
     * 获取到所有Agent分类
     */
    @Get("/v1/api/infra/base/im/chat/getAllCatalog")
    R<List<IndustryRoleCatalogDto>> getAllCatalog();

}
