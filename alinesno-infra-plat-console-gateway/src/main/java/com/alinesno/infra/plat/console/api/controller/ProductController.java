package com.alinesno.infra.plat.console.api.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.plat.console.api.dto.Product;
import com.alinesno.infra.plat.console.api.dto.SubProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @GetMapping("/getProduct")
    public AjaxResult genProduct() {

        log.debug("--->>>>> = StpUtil = {}" , CurrentAccountJwt.isLogin());
        log.debug("--->>>>> = StpUtil = {}" , CurrentAccountJwt.getUserId());

        List<Product> productList = new ArrayList<>();

        // 基础服务
        Product baseService = new Product();
        baseService.setName("基础服务");
        baseService.setBanner("fa-brands fa-slack");
        baseService.setId("2");

        // 01. 权限配置服务
        SubProduct subProduct10001 = new SubProduct();
        subProduct10001.setHasInner(0);
        subProduct10001.setLinkPath("http://alinesno-infra-base-authority-ui.beta.base.infra.linesno.com");
        subProduct10001.setProdStatus("normal");
        subProduct10001.setName("权限配置服务");
        subProduct10001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct10001.setDesc("alinesno-infra-base-authority");

        // 02. 代码生成器
        SubProduct subProduct20001 = new SubProduct();
        subProduct20001.setHasInner(0);
        subProduct20001.setLinkPath("http://alinesno-infra-base-starter-ui.beta.base.infra.linesno.com");
        subProduct20001.setProdStatus("normal");
        subProduct20001.setName("代码生成器");
        subProduct20001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct20001.setDesc("alinesno-infra-base-init");

        // 03. 分布式配置服务
        SubProduct subProduct30001 = new SubProduct();
        subProduct30001.setHasInner(0);
        subProduct30001.setLinkPath("http://alinesno-infra-base-config-ui.beta.base.infra.linesno.com");
        subProduct30001.setProdStatus("normal");
        subProduct30001.setName("分布式配置服务");
        subProduct30001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct30001.setDesc("alinesno-infra-base-config");

        // 04. 事务消息服务
        SubProduct subProduct4 = new SubProduct();
        subProduct4.setHasInner(0);
        subProduct4.setLinkPath("http://alinesno-infra-base-message-ui.beta.base.infra.linesno.com");
        subProduct4.setProdStatus("normal");
        subProduct4.setName("事务消息服务");
        subProduct4.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4.setDesc("alinesno-infra-base-message");

        // 存储管理服务
        SubProduct subProduct6 = new SubProduct();
        subProduct6.setHasInner(0);
        subProduct6.setLinkPath("http://alinesno-infra-base-storage-ui.beta.base.infra.linesno.com");
        subProduct6.setProdStatus("normal");
        subProduct6.setName("存储管理服务");
        subProduct6.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6.setDesc("alinesno-infra-base-storage");

        // 08. 网关配置服务
        SubProduct subProduct8 = new SubProduct();
        subProduct8.setHasInner(0);
        subProduct8.setLinkPath("http://alinesno-infra-base-gateway-ui.beta.base.infra.linesno.com");
        subProduct8.setProdStatus("normal");
        subProduct8.setName("网关配置服务");
        subProduct8.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct8.setDesc("alinesno-infra-base-gateway");

        // 10. IM消息服务
        SubProduct subProduct10 = new SubProduct();
        subProduct10.setHasInner(0);
        subProduct10.setLinkPath("http://alinesno-infra-base-im-ui.beta.base.infra.linesno.com");
        subProduct10.setProdStatus("normal");
        subProduct10.setName("智能体交互服务");
        subProduct10.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct10.setDesc("alinesno-infra-base-im");

        // 12. 向量库搜索服务
        SubProduct subProduct12 = new SubProduct();
        subProduct12.setHasInner(0);
        subProduct12.setLinkPath("http://alinesno-infra-base-search-ui.beta.base.infra.linesno.com");
        subProduct12.setProdStatus("normal");
        subProduct12.setName("向量库搜索服务");
        subProduct12.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct12.setDesc("alinesno-infra-base-document");
 

        // 14. 敏感词过滤服务
        SubProduct subProduct14 = new SubProduct();
        subProduct14.setHasInner(0);
        subProduct14.setLinkPath("http://alinesno-infra-base-sensitive-ui.beta.base.infra.linesno.com");
        subProduct14.setProdStatus("normal");
        subProduct14.setName("敏感词过滤服务");
        subProduct14.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct14.setDesc("alinesno-infra-base-sensitive");

        // 15. 支付服务
        SubProduct subProduct15 = new SubProduct();
        subProduct15.setHasInner(0);
        subProduct15.setLinkPath("http://alinesno-infra-base-pay-ui.beta.base.infra.linesno.com");
        subProduct15.setProdStatus("normal");
        subProduct15.setName("支付服务");
        subProduct15.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct15.setDesc("alinesno-infra-base-pay");

        // 17. 内容服务
        SubProduct subProduct17 = new SubProduct();
        subProduct17.setHasInner(0);
        subProduct17.setLinkPath("http://alinesno-infra-base-cms-ui.beta.base.infra.linesno.com");
        subProduct17.setProdStatus("normal");
        subProduct17.setName("内容管理系统服务");
        subProduct17.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct17.setDesc("alinesno-infra-base-cms");
 

        // 将所有的SubProduct对象添加到基础服务的subList中
        baseService.setSubList(Arrays.asList(
                subProduct10001,
                subProduct20001,
                subProduct30001,
                subProduct4,
                subProduct6,
                subProduct8,
                subProduct10 ,
                subProduct12, 
                subProduct14,
                subProduct15,
                subProduct17  ));

        productList.add(baseService);

        // 创建一个新的Product对象来表示"数据服务"
        Product dataService = new Product();
        dataService.setName("数据服务");
        dataService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        dataService.setBanner("fab fa-angular");

        // 01. 主数据服务
        SubProduct subProduct1002 = new SubProduct();
        subProduct1002.setHasInner(0);
        subProduct1002.setLinkPath("http://alinesno-infra-data-mdm-ui.beta.data.infra.linesno.com");
        subProduct1002.setProdStatus("normal");
        subProduct1002.setName("主数据服务");
        subProduct1002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1002.setDesc("alinesno-infra-data-mdm");

        // 02. 数据上报服务
        SubProduct subProduct2002 = new SubProduct();
        subProduct2002.setHasInner(0);
        subProduct2002.setLinkPath("http://alinesno-infra-data-report-ui.beta.data.infra.linesno.com");
        subProduct2002.setProdStatus("normal");
        subProduct2002.setName("数据上报服务");
        subProduct2002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2002.setDesc("alinesno-infra-data-report");

        // 03. 数据集成服务
        SubProduct subProduct3002 = new SubProduct();
        subProduct3002.setHasInner(0);
        subProduct3002.setLinkPath("http://alinesno-infra-data-pipeline-ui.beta.data.infra.linesno.com");
        subProduct3002.setProdStatus("normal");
        subProduct3002.setName("数据集成服务");
        subProduct3002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3002.setDesc("alinesno-infra-data-pipeline");

        // 04. 数据编排计算服务
        SubProduct subProduct4002 = new SubProduct();
        subProduct4002.setHasInner(0);
        subProduct4002.setLinkPath("http://alinesno-infra-data-dolphinscheduler-ui.beta.data.infra.linesno.com");
        subProduct4002.setProdStatus("normal");
        subProduct4002.setName("数据编排计算服务");
        subProduct4002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4002.setDesc("alinesno-infra-data-dolphinscheduler");

        // 05. 实时计算服务
        SubProduct subProduct51 = new SubProduct();
        subProduct51.setHasInner(0);
        subProduct51.setLinkPath("http://alinesno-infra-data-stream-ui.beta.data.infra.linesno.com");
        subProduct51.setProdStatus("normal");
        subProduct51.setName("实时计算服务");
        subProduct51.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct51.setDesc("alinesno-infra-data-flink");

        // 数据接口服务
        SubProduct subProduct6002 = new SubProduct();
        subProduct6002.setHasInner(0);
        subProduct6002.setLinkPath("http://alinesno-infra-data-fastapi-ui.beta.data.infra.linesno.com");
        subProduct6002.setProdStatus("normal");
        subProduct6002.setName("数据接口服务");
        subProduct6002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6002.setDesc("alinesno-infra-data-security");

        // 09. 数据资产服务
        SubProduct subProduct9002 = new SubProduct();
        subProduct9002.setHasInner(0);
        subProduct9002.setLinkPath("http://alinesno-infra-data-assets-ui.beta.data.infra.linesno.com");
        subProduct9002.setProdStatus("normal");
        subProduct9002.setName("数据资产服务");
        subProduct9002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct9002.setDesc("alinesno-infra-data-assets");

        // 将所有的SubProduct对象添加到数据服务的subList中
        dataService.setSubList(Arrays.asList(subProduct1002,
                subProduct2002,
                subProduct3002,
                subProduct4002,
                subProduct51,
                subProduct6002,
                subProduct9002
        ));

        productList.add(dataService);


        // 创建一个新的Product对象来表示"智能服务"
        Product smartService = new Product();
        smartService.setName("智能服务");
        smartService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        smartService.setBanner("fas fa-chalkboard-teacher");

        // 01. OCR视觉识别服务
        SubProduct subProduct1003 = new SubProduct();
        subProduct1003.setHasInner(0);
        subProduct1003.setLinkPath("http://alinesno-infra-smart-ocr-ui.beta.smart.infra.linesno.com");
        subProduct1003.setProdStatus("normal");
        subProduct1003.setName("OCR视觉识别服务");
        subProduct1003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1003.setDesc("alinesno-infra-smart-ocr");

        // 02. 自然语言识别服务
        SubProduct subProduct2003 = new SubProduct();
        subProduct2003.setHasInner(0);
        subProduct2003.setLinkPath("http://alinesno-infra-smart-nlp-ui.beta.smart.infra.linesno.com");
        subProduct2003.setProdStatus("normal");
        subProduct2003.setName("自然语言识别服务");
        subProduct2003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2003.setDesc("alinesno-infra-smart-nlp");

        // 03. GPT推理服务
        SubProduct subProduct3003 = new SubProduct();
        subProduct3003.setHasInner(0);
        subProduct3003.setLinkPath("http://alinesno-infra-smart-brain-ui.beta.smart.infra.linesno.com");
        subProduct3003.setProdStatus("normal");
        subProduct3003.setName("大模型推理服务");
        subProduct3003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3003.setDesc("alinesno-infra-smart-brain");

        // 05. 智能助手服务
        SubProduct subProduct5003 = new SubProduct();
        subProduct5003.setHasInner(0);
        subProduct5003.setLinkPath("http://alinesno-infra-smart-assistant-ui.beta.smart.infra.linesno.com");
        subProduct5003.setProdStatus("normal");
        subProduct5003.setName("智能助手服务");
        subProduct5003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5003.setDesc("alinesno-infra-smart-assistant");

        // 目标检测识别服务
        SubProduct subProduct6003 = new SubProduct();
        subProduct6003.setHasInner(0);
        subProduct6003.setLinkPath("http://alinesno-infra-smart-detection-ui.beta.smart.infra.linesno.com");
        subProduct6003.setProdStatus("normal");
        subProduct6003.setName("目标检测识别服务");
        subProduct6003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6003.setDesc("alinesno-infra-smart-detection");

        // 将所有的SubProduct对象添加到智能服务的subList中
        smartService.setSubList(Arrays.asList(
                subProduct1003,
                subProduct2003,
                subProduct3003,
                subProduct5003,
                subProduct6003));

        productList.add(smartService);

        // 创建一个新的Product对象来表示"运维服务"
        Product opsService = new Product();
        opsService.setName("运维服务");
        opsService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        opsService.setBanner("fas fa-chalkboard-teacher");

        // 01. 自动化运维服务
        SubProduct subProduct1007 = new SubProduct();
        subProduct1007.setHasInner(0);
        subProduct1007.setLinkPath("http://alinesno-infra-ops-scheduler-ui.beta.base.infra.linesno.com");
        subProduct1007.setProdStatus("normal");
        subProduct1007.setName("自动化运维服务");
        subProduct1007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1007.setDesc("alinesno-infra-ops-scheduler");

        // 02. 分布式日志服务
        SubProduct subProduct2007 = new SubProduct();
        subProduct2007.setHasInner(0);
        subProduct2007.setLinkPath("http://alinesno-infra-ops-logback-ui.beta.base.infra.linesno.com");
        subProduct2007.setProdStatus("normal");
        subProduct2007.setName("分布式日志服务");
        subProduct2007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2007.setDesc("alinesno-infra-ops-logback");

        // 05. 容器管理服务
        SubProduct subProduct5007 = new SubProduct();
        subProduct5007.setHasInner(0);
        subProduct5007.setLinkPath("http://alinesno-infra-ops-container-ui.beta.base.infra.linesno.com");
        subProduct5007.setProdStatus("normal");
        subProduct5007.setName("容器管理服务");
        subProduct5007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5007.setDesc("alinesno-infra-ops-container");

        // 监控预警服务
        SubProduct subProduct6007 = new SubProduct();
        subProduct6007.setHasInner(0);
        subProduct6007.setLinkPath("http://alinesno-infra-ops-watcher-ui.beta.base.infra.linesno.com");
        subProduct6007.setProdStatus("normal");
        subProduct6007.setName("监控预警服务");
        subProduct6007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6007.setDesc("alinesno-infra-ops-watcher");

        // 将所有的SubProduct对象添加到运维服务的subList中
        opsService.setSubList(Arrays.asList(
                subProduct1007,
                subProduct2007,
                subProduct5007,
                subProduct6007));

        productList.add(opsService);

        // 创建一个新的Product对象来表示"业务服务"
        Product busService = new Product();
        busService.setName("业务服务");
        busService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        busService.setBanner("fas fa-chalkboard-teacher");

        // 02. 实时推荐服务
        SubProduct subProduct2008 = new SubProduct();
        subProduct2008.setHasInner(0);
        subProduct2008.setLinkPath("http://alinesno-infra-bus-recommend-ui.beta.data.infra.linesno.com");
        subProduct2008.setProdStatus("normal");
        subProduct2008.setName("实时推荐服务");
        subProduct2008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2008.setDesc("alinesno-infra-bus-recommend");

        // 03. 实时画像服务
        SubProduct subProduct3008 = new SubProduct();
        subProduct3008.setHasInner(0);
        subProduct3008.setLinkPath("http://alinesno-infra-bus-profiling-ui.beta.data.infra.linesno.com");
        subProduct3008.setProdStatus("normal");
        subProduct3008.setName("实时画像服务");
        subProduct3008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3008.setDesc("alinesno-infra-bus-profiling");

        // 将所有的SubProduct对象添加到业务服务的subList中
        busService.setSubList(Arrays.asList(subProduct2008, subProduct3008));

        productList.add(busService);

        // 创建一个新的Product对象来表示"运营服务"
        Product platService = new Product();
        platService.setName("运营服务");
        platService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        platService.setBanner("fas fa-chalkboard-teacher");

        // 02. 安全感触服务
        SubProduct subProduct2009 = new SubProduct();
        subProduct2009.setHasInner(0);
        subProduct2009.setLinkPath("http://alinesno-infra-plat-security-ui.beta.plat.infra.linesno.com");
        subProduct2009.setProdStatus("normal");
        subProduct2009.setName("安全感触服务");
        subProduct2009.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2009.setDesc("alinesno-infra-plat-security");

        // 21. 基设平台管理服务
        SubProduct subProduct21 = new SubProduct();
        subProduct21.setHasInner(0);
        subProduct21.setLinkPath("http://alinesno-infra-base-platform-ui.beta.base.infra.linesno.com");
        subProduct21.setProdStatus("normal");
        subProduct21.setName("基设平台管理服务");
        subProduct21.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct21.setDesc("alinesno-infra-base-platform");

        // 将所有的SubProduct对象添加到运营服务的subList中
        platService.setSubList(Arrays.asList(subProduct21 , subProduct2009));

        productList.add(platService);

        return AjaxResult.success(productList);
    }

}
