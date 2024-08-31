package com.alinesno.infra.plat.console.api.controller;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.plat.console.adapter.BasePlatformProductConsumer;
import com.alinesno.infra.plat.console.adapter.dto.ProductTypeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/productType/")
public class ProductTypeController {

    @Autowired
    private BasePlatformProductConsumer productConsumer ;

    @PostMapping("/save")
    public AjaxResult saveProductType(@RequestBody ProductTypeDto productTypeDto) {

        long orgId = 1234568L ;

        productTypeDto.setCode(IdUtil.nanoId(8));
        productTypeDto.setOrgId(orgId);
        productTypeDto.setTypeOwner("org");

        String res = productConsumer.saveOrgProductCategory(productTypeDto).getData() ;
        return AjaxResult.success(res);
    }

    /**
     * 查询组织产品分类
     */
    @GetMapping("/datatables")
    public AjaxResult queryOrgProductCategory() {

        long orgId = 1234568L ;

        List<ProductTypeDto> productTypeDtoList = productConsumer.queryOrgProductCategory(orgId).getData() ;
        return AjaxResult.success(productTypeDtoList);
    }

}
