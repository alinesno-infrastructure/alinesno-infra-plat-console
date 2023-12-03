package com.alinesno.infra.plat.console.api.controller;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.plat.console.api.dto.Product;
import com.alinesno.infra.plat.console.api.dto.SubProduct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @GetMapping("/getProduct")
    public AjaxResult genProduct() {

        List<Product> productList = new ArrayList<>();

        // 基础服务
        Product baseService = new Product();
        baseService.setName("基础服务");
        baseService.setBanner("fa-brands fa-slack");
        baseService.setId("2");

        // 01. 权限配置服务
        SubProduct subProduct10001 = new SubProduct();
        subProduct10001.setHasInner(0);
        subProduct10001.setLinkPath("http://alinesno-infra-base-authority-admin.beta.base.infra.linesno.com");
        subProduct10001.setProdStatus("normal");
        subProduct10001.setName("权限配置服务");
        subProduct10001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct10001.setDesc("alinesno-infra-base-authority");

        // 02. 代码生成器
        SubProduct subProduct20001 = new SubProduct();
        subProduct20001.setHasInner(0);
        subProduct20001.setLinkPath("http://alinesno-infra-base-starter-admin.beta.base.infra.linesno.com");
        subProduct20001.setProdStatus("normal");
        subProduct20001.setName("代码生成器");
        subProduct20001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct20001.setDesc("alinesno-infra-base-init");

        // 03. 分布式配置服务
        SubProduct subProduct30001 = new SubProduct();
        subProduct30001.setHasInner(0);
        subProduct30001.setLinkPath("http://alinesno-infra-base-config-admin.beta.base.infra.linesno.com");
        subProduct30001.setProdStatus("normal");
        subProduct30001.setName("分布式配置服务");
        subProduct30001.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct30001.setDesc("alinesno-infra-base-config");

        // 04. 事务消息服务
        SubProduct subProduct4 = new SubProduct();
        subProduct4.setHasInner(0);
        subProduct4.setLinkPath("http://alinesno-infra-base-message-admin.beta.base.infra.linesno.com");
        subProduct4.setProdStatus("normal");
        subProduct4.setName("事务消息服务");
        subProduct4.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4.setDesc("alinesno-infra-base-message");

        // 05. 通知管理服务
        SubProduct subProduct5 = new SubProduct();
        subProduct5.setHasInner(0);
        subProduct5.setLinkPath("http://alinesno-infra-base-notice-admin.beta.base.infra.linesno.com");
        subProduct5.setProdStatus("normal");
        subProduct5.setName("通知管理服务");
        subProduct5.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5.setDesc("alinesno-infra-base-notices");

        // 存储管理服务
        SubProduct subProduct6 = new SubProduct();
        subProduct6.setHasInner(0);
        subProduct6.setLinkPath("http://alinesno-infra-base-storage-admin.beta.base.infra.linesno.com");
        subProduct6.setProdStatus("normal");
        subProduct6.setName("存储管理服务");
        subProduct6.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6.setDesc("alinesno-infra-base-storage");

        // 07. 单点登陆服务
        SubProduct subProduct7 = new SubProduct();
        subProduct7.setHasInner(0);
        subProduct7.setLinkPath("http://alinesno-infra-base-identity-admin.beta.base.infra.linesno.com");
        subProduct7.setProdStatus("normal");
        subProduct7.setName("单点登陆服务");
        subProduct7.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct7.setDesc("alinesno-infra-base-identity");

        // 08. 网关配置服务
        SubProduct subProduct8 = new SubProduct();
        subProduct8.setHasInner(0);
        subProduct8.setLinkPath("http://alinesno-infra-base-gateway-admin.beta.base.infra.linesno.com");
        subProduct8.setProdStatus("normal");
        subProduct8.setName("网关配置服务");
        subProduct8.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct8.setDesc("alinesno-infra-base-gateway");

        // 09. 安全验证码服务
        SubProduct subProduct9 = new SubProduct();
        subProduct9.setHasInner(0);
        subProduct9.setLinkPath("http://alinesno-infra-base-validate-admin.beta.base.infra.linesno.com");
        subProduct9.setProdStatus("normal");
        subProduct9.setName("安全验证码服务");
        subProduct9.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct9.setDesc("alinesno-infra-base-validate");

        // 10. IM消息服务
        SubProduct subProduct10 = new SubProduct();
        subProduct10.setHasInner(0);
        subProduct10.setLinkPath("http://alinesno-infra-base-im-admin.beta.base.infra.linesno.com");
        subProduct10.setProdStatus("normal");
        subProduct10.setName("IM消息服务");
        subProduct10.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct10.setDesc("alinesno-infra-base-im");

        // 11. 邮箱管理服务
        SubProduct subProduct11 = new SubProduct();
        subProduct11.setHasInner(0);
        subProduct11.setLinkPath("http://alinesno-infra-base-email-admin.beta.base.infra.linesno.com");
        subProduct11.setProdStatus("normal");
        subProduct11.setName("邮箱管理服务");
        subProduct11.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct11.setDesc("alinesno-infra-base-email");

        // 12. 文档搜索服务
        SubProduct subProduct12 = new SubProduct();
        subProduct12.setHasInner(0);
        subProduct12.setLinkPath("http://alinesno-infra-base-document-admin.beta.base.infra.linesno.com");
        subProduct12.setProdStatus("normal");
        subProduct12.setName("文档搜索服务");
        subProduct12.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct12.setDesc("alinesno-infra-base-document");

        // 13. 分布式ID服务
        SubProduct subProduct13 = new SubProduct();
        subProduct13.setHasInner(0);
        subProduct13.setLinkPath("http://alinesno-infra-base-id-admin.beta.base.infra.linesno.com");
        subProduct13.setProdStatus("normal");
        subProduct13.setName("分布式ID服务");
        subProduct13.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct13.setDesc("alinesno-infra-base-id");

        // 14. 敏感词过滤服务
        SubProduct subProduct14 = new SubProduct();
        subProduct14.setHasInner(0);
        subProduct14.setLinkPath("http://alinesno-infra-base-sensitive-admin.beta.base.infra.linesno.com");
        subProduct14.setProdStatus("normal");
        subProduct14.setName("敏感词过滤服务");
        subProduct14.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct14.setDesc("alinesno-infra-base-sensitive");

        // 15. 支付服务
        SubProduct subProduct15 = new SubProduct();
        subProduct15.setHasInner(0);
        subProduct15.setLinkPath("http://alinesno-infra-base-pay-admin.beta.base.infra.linesno.com");
        subProduct15.setProdStatus("normal");
        subProduct15.setName("支付服务");
        subProduct15.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct15.setDesc("alinesno-infra-base-pay");

        // 16. 会员服务
        SubProduct subProduct16 = new SubProduct();
        subProduct16.setHasInner(0);
        subProduct16.setLinkPath("http://alinesno-infra-base-member-admin.beta.base.infra.linesno.com");
        subProduct16.setProdStatus("normal");
        subProduct16.setName("会员服务");
        subProduct16.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct16.setDesc("alinesno-infra-base-member");

        // 17. 内容服务
        SubProduct subProduct17 = new SubProduct();
        subProduct17.setHasInner(0);
        subProduct17.setLinkPath("http://alinesno-infra-base-cms-admin.beta.base.infra.linesno.com");
        subProduct17.setProdStatus("normal");
        subProduct17.setName("内容服务");
        subProduct17.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct17.setDesc("alinesno-infra-base-cms");

        // 18. 商城服务
        SubProduct subProduct18 = new SubProduct();
        subProduct18.setHasInner(0);
        subProduct18.setLinkPath("http://alinesno-infra-base-shop-admin.beta.base.infra.linesno.com");
        subProduct18.setProdStatus("normal");
        subProduct18.setName("商城服务");
        subProduct18.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct18.setDesc("alinesno-infra-base-shop");

        // 19. 流程中心服务
        SubProduct subProduct19 = new SubProduct();
        subProduct19.setHasInner(0);
        subProduct19.setLinkPath("http://alinesno-infra-base-workflow-admin.beta.base.infra.linesno.com");
        subProduct19.setProdStatus("normal");
        subProduct19.setName("流程中心服务");
        subProduct19.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct19.setDesc("alinesno-infra-base-workflow");

        // 20. 文档查看服务
        SubProduct subProduct20 = new SubProduct();
        subProduct20.setHasInner(0);
        subProduct20.setLinkPath("http://alinesno-infra-base-fileshow-admin.beta.base.infra.linesno.com");
        subProduct20.setProdStatus("normal");
        subProduct20.setName("文档查看服务");
        subProduct20.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct20.setDesc("alinesno-infra-base-fileshow");

        // 将所有的SubProduct对象添加到基础服务的subList中
        baseService.setSubList(Arrays.asList(subProduct10001, subProduct20001, subProduct30001, subProduct4, subProduct5, subProduct6, subProduct7, subProduct8, subProduct9, subProduct10, subProduct11, subProduct12, subProduct13, subProduct14, subProduct15, subProduct16, subProduct17, subProduct18, subProduct19, subProduct20 ));

        productList.add(baseService);

        // 创建一个新的Product对象来表示"数据服务"
        Product dataService = new Product();
        dataService.setName("数据服务");
        dataService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        dataService.setBanner("fab fa-angular");

        // 01. 主数据服务
        SubProduct subProduct1002 = new SubProduct();
        subProduct1002.setHasInner(0);
        subProduct1002.setLinkPath("http://alinesno-infra-data-mdm-admin.beta.data.infra.linesno.com");
        subProduct1002.setProdStatus("normal");
        subProduct1002.setName("主数据服务");
        subProduct1002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1002.setDesc("alinesno-infra-data-mdm");

        // 02. 数据上报服务
        SubProduct subProduct2002 = new SubProduct();
        subProduct2002.setHasInner(0);
        subProduct2002.setLinkPath("http://alinesno-infra-data-report-admin.beta.data.infra.linesno.com");
        subProduct2002.setProdStatus("normal");
        subProduct2002.setName("数据上报服务");
        subProduct2002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2002.setDesc("alinesno-infra-data-report");

        // 03. 数据集成服务
        SubProduct subProduct3002 = new SubProduct();
        subProduct3002.setHasInner(0);
        subProduct3002.setLinkPath("http://alinesno-infra-data-pipeline-admin.beta.data.infra.linesno.com");
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
        subProduct51.setLinkPath("http://alinesno-infra-data-stream-admin.beta.data.infra.linesno.com");
        subProduct51.setProdStatus("normal");
        subProduct51.setName("实时计算服务");
        subProduct51.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct51.setDesc("alinesno-infra-data-flink");

        // 数据安全服务
        SubProduct subProduct6002 = new SubProduct();
        subProduct6002.setHasInner(0);
        subProduct6002.setLinkPath("http://alinesno-infra-data-security-admin.beta.data.infra.linesno.com");
        subProduct6002.setProdStatus("normal");
        subProduct6002.setName("数据安全服务");
        subProduct6002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6002.setDesc("alinesno-infra-data-security");

        // 07. 数据质量服务
        SubProduct subProduct7002 = new SubProduct();
        subProduct7002.setHasInner(0);
        subProduct7002.setLinkPath("http://alinesno-infra-data-quality-admin.beta.data.infra.linesno.com");
        subProduct7002.setProdStatus("normal");
        subProduct7002.setName("数据质量服务");
        subProduct7002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct7002.setDesc("alinesno-infra-data-quality");

        // 08. 数据总线服务
        SubProduct subProduct8002 = new SubProduct();
        subProduct8002.setHasInner(0);
        subProduct8002.setLinkPath("http://alinesno-infra-data-bus-admin.beta.data.infra.linesno.com");
        subProduct8002.setProdStatus("normal");
        subProduct8002.setName("数据总线服务");
        subProduct8002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct8002.setDesc("alinesno-infra-data-bus");

        // 09. 数据资产服务
        SubProduct subProduct9002 = new SubProduct();
        subProduct9002.setHasInner(0);
        subProduct9002.setLinkPath("http://alinesno-infra-data-assets-admin.beta.data.infra.linesno.com");
        subProduct9002.setProdStatus("normal");
        subProduct9002.setName("数据资产服务");
        subProduct9002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct9002.setDesc("alinesno-infra-data-assets");

        // 10. 数据算法服务
        SubProduct subProduct10002 = new SubProduct();
        subProduct10002.setHasInner(0);
        subProduct10002.setLinkPath("http://alinesno-infra-data-algorithm-admin.beta.data.infra.linesno.com");
        subProduct10002.setProdStatus("normal");
        subProduct10002.setName("数据算法服务");
        subProduct10002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct10002.setDesc("alinesno-infra-data-algorithm");

        // 10. 数据算法服务
        SubProduct subProduct11002 = new SubProduct();
        subProduct11002.setHasInner(0);
        subProduct11002.setLinkPath("http://alinesno-infra-data-fastapi-admin.beta.data.infra.linesno.com");
        subProduct11002.setProdStatus("normal");
        subProduct11002.setName("数据接口服务");
        subProduct11002.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct11002.setDesc("alinesno-infra-data-fastapi");

        // 将所有的SubProduct对象添加到数据服务的subList中
        dataService.setSubList(Arrays.asList(subProduct1002, subProduct2002, subProduct3002, subProduct4002, subProduct51, subProduct6002, subProduct7002, subProduct8002, subProduct9002, subProduct10002 , subProduct11002));

        productList.add(dataService);


        // 创建一个新的Product对象来表示"智能服务"
        Product smartService = new Product();
        smartService.setName("智能服务");
        smartService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        smartService.setBanner("fas fa-chalkboard-teacher");

        // 01. OCR视觉识别服务
        SubProduct subProduct1003 = new SubProduct();
        subProduct1003.setHasInner(0);
        subProduct1003.setLinkPath("http://alinesno-infra-smart-ocr-admin.beta.smart.infra.linesno.com");
        subProduct1003.setProdStatus("normal");
        subProduct1003.setName("OCR视觉识别服务");
        subProduct1003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1003.setDesc("alinesno-infra-smart-ocr");

        // 02. 自然语言识别服务
        SubProduct subProduct2003 = new SubProduct();
        subProduct2003.setHasInner(0);
        subProduct2003.setLinkPath("http://alinesno-infra-smart-nlp-admin.beta.smart.infra.linesno.com");
        subProduct2003.setProdStatus("normal");
        subProduct2003.setName("自然语言识别服务");
        subProduct2003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2003.setDesc("alinesno-infra-smart-nlp");

        // 03. GPT推理服务
        SubProduct subProduct3003 = new SubProduct();
        subProduct3003.setHasInner(0);
        subProduct3003.setLinkPath("http://alinesno-infra-smart-brain-ui.beta.smart.infra.linesno.com");
        subProduct3003.setProdStatus("normal");
        subProduct3003.setName("GPT推理服务");
        subProduct3003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3003.setDesc("alinesno-infra-smart-brain");

        // 04. 流媒体识别服务
        SubProduct subProduct4003 = new SubProduct();
        subProduct4003.setHasInner(0);
        subProduct4003.setLinkPath("http://alinesno-infra-smart-media-admin.beta.smart.infra.linesno.com");
        subProduct4003.setProdStatus("normal");
        subProduct4003.setName("流媒体识别服务");
        subProduct4003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4003.setDesc("alinesno-infra-smart-media");

        // 05. 智能助手服务
        SubProduct subProduct5003 = new SubProduct();
        subProduct5003.setHasInner(0);
        subProduct5003.setLinkPath("http://alinesno-infra-smart-assistant-admin.beta.smart.infra.linesno.com");
        subProduct5003.setProdStatus("normal");
        subProduct5003.setName("智能助手服务");
        subProduct5003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5003.setDesc("alinesno-infra-smart-assistant");

        // 目标检测识别服务
        SubProduct subProduct6003 = new SubProduct();
        subProduct6003.setHasInner(0);
        subProduct6003.setLinkPath("http://alinesno-infra-smart-detection-admin.beta.smart.infra.linesno.com");
        subProduct6003.setProdStatus("normal");
        subProduct6003.setName("目标检测识别服务");
        subProduct6003.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6003.setDesc("alinesno-infra-smart-detection");

        // 将所有的SubProduct对象添加到智能服务的subList中
        smartService.setSubList(Arrays.asList(subProduct1003, subProduct2003, subProduct3003, subProduct4003, subProduct5003, subProduct6003));

        productList.add(smartService);

        // 创建一个新的Product对象来表示"运维服务"
        Product opsService = new Product();
        opsService.setName("运维服务");
        opsService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        opsService.setBanner("fas fa-chalkboard-teacher");

        // 01. 自动化任务服务
        SubProduct subProduct1007 = new SubProduct();
        subProduct1007.setHasInner(0);
        subProduct1007.setLinkPath("http://alinesno-infra-ops-scheduler-admin.beta.base.infra.linesno.com");
        subProduct1007.setProdStatus("normal");
        subProduct1007.setName("自动化任务服务");
        subProduct1007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1007.setDesc("alinesno-infra-ops-scheduler");

        // 02. 分布式日志服务
        SubProduct subProduct2007 = new SubProduct();
        subProduct2007.setHasInner(0);
        subProduct2007.setLinkPath("http://alinesno-infra-ops-logback-admin.beta.base.infra.linesno.com");
        subProduct2007.setProdStatus("normal");
        subProduct2007.setName("分布式日志服务");
        subProduct2007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2007.setDesc("alinesno-infra-ops-logback");

        // 03. 分布式链路跟踪服务
        SubProduct subProduct3007 = new SubProduct();
        subProduct3007.setHasInner(0);
        subProduct3007.setLinkPath("http://alinesno-infra-ops-telemetry-admin.beta.base.infra.linesno.com");
        subProduct3007.setProdStatus("normal");
        subProduct3007.setName("分布式链路跟踪服务");
        subProduct3007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3007.setDesc("alinesno-infra-ops-telemetry");

        // 04. 持续集成服务
        SubProduct subProduct4007 = new SubProduct();
        subProduct4007.setHasInner(0);
        subProduct4007.setLinkPath("http://alinesno-infra-ops-pipeline-admin.beta.base.infra.linesno.com");
        subProduct4007.setProdStatus("normal");
        subProduct4007.setName("持续集成服务");
        subProduct4007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4007.setDesc("alinesno-infra-ops-pipeline");

        // 05. 容器管理服务
        SubProduct subProduct5007 = new SubProduct();
        subProduct5007.setHasInner(0);
        subProduct5007.setLinkPath("http://alinesno-infra-ops-container-admin.beta.base.infra.linesno.com");
        subProduct5007.setProdStatus("normal");
        subProduct5007.setName("容器管理服务");
        subProduct5007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5007.setDesc("alinesno-infra-ops-container");

        // 监控预警服务
        SubProduct subProduct6007 = new SubProduct();
        subProduct6007.setHasInner(0);
        subProduct6007.setLinkPath("http://alinesno-infra-ops-watcher-admin.beta.base.infra.linesno.com");
        subProduct6007.setProdStatus("normal");
        subProduct6007.setName("监控预警服务");
        subProduct6007.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct6007.setDesc("alinesno-infra-ops-watcher");

        // 将所有的SubProduct对象添加到运维服务的subList中
        opsService.setSubList(Arrays.asList(subProduct1007, subProduct2007, subProduct3007, subProduct4007, subProduct5007, subProduct6007));

        productList.add(opsService);

        // 创建一个新的Product对象来表示"业务服务"
        Product busService = new Product();
        busService.setName("业务服务");
        busService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        busService.setBanner("fas fa-chalkboard-teacher");

        // 01. 商品秒杀服务
        SubProduct subProduct1008 = new SubProduct();
        subProduct1008.setHasInner(0);
        subProduct1008.setLinkPath("http://alinesno-infra-bus-limit-admin.beta.data.infra.linesno.com");
        subProduct1008.setProdStatus("normal");
        subProduct1008.setName("商品秒杀服务");
        subProduct1008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct1008.setDesc("alinesno-infra-bus-limit");

        // 02. 实时推荐服务
        SubProduct subProduct2008 = new SubProduct();
        subProduct2008.setHasInner(0);
        subProduct2008.setLinkPath("http://alinesno-infra-bus-recommend-admin.beta.data.infra.linesno.com");
        subProduct2008.setProdStatus("normal");
        subProduct2008.setName("实时推荐服务");
        subProduct2008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2008.setDesc("alinesno-infra-bus-recommend");

        // 03. 实时画像服务
        SubProduct subProduct3008 = new SubProduct();
        subProduct3008.setHasInner(0);
        subProduct3008.setLinkPath("http://alinesno-infra-bus-profiling-admin.beta.data.infra.linesno.com");
        subProduct3008.setProdStatus("normal");
        subProduct3008.setName("实时画像服务");
        subProduct3008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3008.setDesc("alinesno-infra-bus-profiling");

        // 04. 无代码开发服务
        SubProduct subProduct4008 = new SubProduct();
        subProduct4008.setHasInner(0);
        subProduct4008.setLinkPath("http://alinesno-infra-bus-nocode-admin.beta.data.infra.linesno.com");
        subProduct4008.setProdStatus("normal");
        subProduct4008.setName("无代码开发服务");
        subProduct4008.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4008.setDesc("alinesno-infra-bus-nocode");

        // 将所有的SubProduct对象添加到业务服务的subList中
        busService.setSubList(Arrays.asList(subProduct1008, subProduct2008, subProduct3008, subProduct4008));

        productList.add(busService);

        // 创建一个新的Product对象来表示"运营服务"
        Product platService = new Product();
        platService.setName("运营服务");
        platService.setId("fbd5d9a8d5f84c50b12235363f7f8e8b");
        platService.setBanner("fas fa-chalkboard-teacher");

        // 02. 安全感触服务
        SubProduct subProduct2009 = new SubProduct();
        subProduct2009.setHasInner(0);
        subProduct2009.setLinkPath("http://alinesno-infra-plat-security-admin.beta.plat.infra.linesno.com");
        subProduct2009.setProdStatus("normal");
        subProduct2009.setName("安全感触服务");
        subProduct2009.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct2009.setDesc("alinesno-infra-plat-security");

        // 03. 智能运营大脑服务
        SubProduct subProduct3009 = new SubProduct();
        subProduct3009.setHasInner(0);
        subProduct3009.setLinkPath("http://alinesno-infra-plat-security-admin.beta.plat.infra.linesno.com");
        subProduct3009.setProdStatus("normal");
        subProduct3009.setName("智能运营大脑服务");
        subProduct3009.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct3009.setDesc("alinesno-infra-plat-brain");

        // 21. 基设平台管理服务
        SubProduct subProduct21 = new SubProduct();
        subProduct21.setHasInner(0);
        subProduct21.setLinkPath("http://alinesno-infra-base-platform-admin.beta.base.infra.linesno.com");
        subProduct21.setProdStatus("normal");
        subProduct21.setName("基设平台管理服务");
        subProduct21.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct21.setDesc("alinesno-infra-base-platform");

        // 21. 项目管理服务
        SubProduct subProduct4009 = new SubProduct();
        subProduct4009.setHasInner(0);
        subProduct4009.setLinkPath("http://alinesno-infra-plat-project-admin.beta.plat.infra.linesno.com");
        subProduct4009.setProdStatus("normal");
        subProduct4009.setName("项目管理服务");
        subProduct4009.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct4009.setDesc("alinesno-infra-base-project");

        // 21. 认证授权服务
        SubProduct subProduct5009 = new SubProduct();
        subProduct5009.setHasInner(0);
        subProduct5009.setLinkPath("http://alinesno-infra-base-identity-auth-application.beta.base.infra.linesno.com");
        subProduct5009.setProdStatus("normal");
        subProduct5009.setName("认证授权服务");
        subProduct5009.setId("c6fca12e348cccf97495b3aea33adcef");
        subProduct5009.setDesc("alinesno-infra-base-platform");

        // 将所有的SubProduct对象添加到运营服务的subList中
        platService.setSubList(Arrays.asList(subProduct21 , subProduct2009, subProduct3009 , subProduct4009 , subProduct5009 ));

        productList.add(platService);

        return AjaxResult.success(productList);
    }

}
