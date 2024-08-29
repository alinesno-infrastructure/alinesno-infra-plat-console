package com.alinesno.infra.plat.console.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.plat.console.adapter.BasePlatformProductConsumer;
import com.alinesno.infra.plat.console.adapter.dto.ProductItemDto;
import com.alinesno.infra.plat.console.adapter.dto.ProductTypeDto;
import com.alinesno.infra.plat.console.api.dto.Product;
import com.alinesno.infra.plat.console.api.dto.SubProduct;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private BasePlatformProductConsumer productConsumer ;

    @GetMapping("/getProduct")
    public AjaxResult genProduct() {
        long orgId = 0L ;
        List<ProductTypeDto> productDtoList = productConsumer.queryOrgProductCategory(orgId).getData() ;
        return AjaxResult.success(productDtoList);
    }

    @GetMapping("/getProductByTypeCode")
    public AjaxResult getProductByTypeCode(String typeCode) {
        List<ProductItemDto> productItemDtoList = productConsumer.queryProductByTypeCode(typeCode).getData() ;
        return AjaxResult.success(productItemDtoList);
    }

    @PostMapping("/save")
    public AjaxResult saveProductType(@RequestBody ProductItemDto productItemDto) {

        long orgId = 123456L ;

        productItemDto.setOrgId(orgId);
        productItemDto.setProductOwner("org");
        productItemDto.setProdStatus("internal");
        productItemDto.setIdentityStatus("enabled");
        productItemDto.setIsPublic(1);

        String res = productConsumer.saveOrgProduct(productItemDto).getData() ;
        return AjaxResult.success(res);
    }

}
