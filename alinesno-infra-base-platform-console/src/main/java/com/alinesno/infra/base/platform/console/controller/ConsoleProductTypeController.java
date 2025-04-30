package com.alinesno.infra.base.platform.console.controller;

import cn.hutool.core.util.IdUtil;
import com.alinesno.infra.base.platform.api.dto.ProductTypeDto;
import com.alinesno.infra.base.platform.service.IProductTypeService;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/productType/")
public class ConsoleProductTypeController {

//    @Autowired
//    private BasePlatformProductConsumer productConsumer ;

    @Autowired
    private IProductTypeService productConsumer;

    @PostMapping("/save")
    public AjaxResult saveProductType(@RequestBody ProductTypeDto productTypeDto) {

        long orgId = CurrentAccountJwt.get().getOrgId(); ;

        productTypeDto.setCode(IdUtil.nanoId(8));
        productTypeDto.setOrgId(orgId);
        productTypeDto.setTypeOwner("org");

        productConsumer.saveOrgProductCategory(productTypeDto) ;
        return AjaxResult.success();
    }

    /**
     * 查询组织产品分类
     */
    @GetMapping("/datatables")
    public AjaxResult queryOrgProductCategory() {

        long orgId = CurrentAccountJwt.get().getOrgId(); ;

        List<ProductTypeDto> productTypeDtoList = productConsumer.findByOrgId(String.valueOf(orgId)) ;
        return AjaxResult.success(productTypeDtoList);
    }

}
