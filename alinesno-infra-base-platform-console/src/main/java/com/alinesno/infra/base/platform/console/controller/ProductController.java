package com.alinesno.infra.base.platform.console.controller;

import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.api.dto.ProductTypeDto;
import com.alinesno.infra.base.platform.service.IProductItemService;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    private IProductItemService productConsumer ;

    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("/getProduct")
    public AjaxResult genProduct() {
        long orgId = CurrentAccountJwt.get().getOrgId(); ;
        List<ProductTypeDto> productDtoList = productTypeService.findByOrgId(String.valueOf(orgId)) ;
        return AjaxResult.success(productDtoList);
    }

    @GetMapping("/getProductByTypeCode")
    public AjaxResult getProductByTypeCode(String typeCode) {
        List<ProductItemDto> productItemDtoList = productConsumer.queryProductByTypeCode(typeCode) ;
        return AjaxResult.success(productItemDtoList);
    }

    @PostMapping("/save")
    public AjaxResult saveProductType(@RequestBody ProductItemDto productItemDto) {

        long orgId = CurrentAccountJwt.get().getOrgId(); ;

        productItemDto.setOrgId(orgId);
        productItemDto.setProductOwner("org");
        productItemDto.setProdStatus("internal");
        productItemDto.setIdentityStatus("enabled");
        productItemDto.setIsPublic(1);

        productConsumer.saveOrgProduct(productItemDto) ;
        return AjaxResult.success();
    }

}
