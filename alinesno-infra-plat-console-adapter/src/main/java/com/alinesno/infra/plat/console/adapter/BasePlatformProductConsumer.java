package com.alinesno.infra.plat.console.adapter;

import com.alinesno.infra.plat.console.adapter.dto.ProductItemDto;
import com.alinesno.infra.plat.console.adapter.dto.ProductTypeDto;
import com.dtflys.forest.annotation.*;
import com.alinesno.infra.common.facade.response.R;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 平台消费者基类
 */
@BaseRequest(
        baseURL = "#{alinesno.infra.gateway.host}/base-platform" ,
        connectTimeout = 30*1000
)
public interface BasePlatformProductConsumer {

    /**
     * 保存组织业务产品
     */
    @Post("/api/infra/base/platform/provider/product/saveOrgProduct")
    R<String> saveOrgProduct(@Body ProductItemDto productItemDto);

    /**
     * 保存组织产品分类
     */
    @Post("/api/infra/base/platform/provider/product/saveOrgProductCategory")
    R<String> saveOrgProductCategory(@Body ProductTypeDto productTypeDto);

    /**
     * 查询组织产品分类
     */
    @Get("/api/infra/base/platform/provider/product/queryOrgProductCategory")
    R<List<ProductTypeDto>> queryOrgProductCategory(@Param("orgId") long orgId);

    /**
     * 通过分类标识查询产品列表
     */
    @Get("/api/infra/base/platform/provider/product/queryProductByTypeCode")
    R<List<ProductItemDto>> queryProductByTypeCode(@Param("typeCode") String typeCode);

}