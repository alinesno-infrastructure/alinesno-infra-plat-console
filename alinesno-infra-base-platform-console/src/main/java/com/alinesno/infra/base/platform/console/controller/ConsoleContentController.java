package com.alinesno.infra.base.platform.console.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/plat/console/content")
public class ConsoleContentController {

    /**
     * 通过分类代码获取内容列表
     * @param categoryCode
     * @return
     */
    @GetMapping("/getContentByCategory")
    public AjaxResult getContentByCategory(String categoryCode) {
        return AjaxResult.success();
    }

}
