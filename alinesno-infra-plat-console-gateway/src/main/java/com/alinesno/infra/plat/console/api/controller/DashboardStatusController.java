package com.alinesno.infra.plat.console.api.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.plat.console.api.tools.CheckinUtils;
import com.alinesno.infra.plat.console.api.tools.TimePeriodTool;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * 处理与AccountSiteEntity相关的请求的Controller。
 * 继承自BaseController类并实现AccountSiteService接口。
 *
 * @version 1.0.0
 * @since 1.0.0
 * @author luoxiaodong
 */
@Slf4j
@Api(tags = "DashboardStatusController")
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/plat/console/status")
public class DashboardStatusController extends SuperController {

    /**
     * 获取当前时间段
     */
    @RequestMapping("/current-time-period")
    public AjaxResult getCurrentTimePeriod() {
        String timePeriod = TimePeriodTool.getTimePeriod();
        return AjaxResult.success("当前时间段是：" + timePeriod);
    }


    /**
     * 获取 logo 图片的 Base64 位
     */
    @RequestMapping("/logo-base64")
    public AjaxResult getLogoBase64FromUrl() {
        String imageUrl = "http://portal.infra.linesno.com/logo.png"; // 图片的 URL
        String base64Image = null;

        try {
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream = connection.getInputStream();
            byte[] imageBytes = inputStream.readAllBytes();
            base64Image = Base64.getEncoder().encodeToString(imageBytes);

            inputStream.close();
            connection.disconnect();
        } catch (IOException e) {
            log.error("Error reading logo image from URL: " + e.getMessage());
        }

        return AjaxResult.success(base64Image);
    }

    /**
     * 返回签到天数
     */
    @RequestMapping("/checkin-days")
    public AjaxResult getCheckinDays() {
        // 在此处编写获取签到天数的逻辑，可以从工具类中获取
        return AjaxResult.success(CheckinUtils.getCheckinDays());
    }

    /**
     * 获取应用列表
     * @return
     */
    @GetMapping("/screenJsonList")
    public AjaxResult getScreenJsonList() {
        String screenJsonList = "[\n" +
                "  {\n" +
                "    \"addTime\": \"2023-05-02 05:15:12\",\n" +
                "    \"departmentId\": null,\n" +
                "    \"lastUpdateOperatorId\": null,\n" +
                "    \"usage\": 7,\n" +
                "    \"icon\": 'https://d1by4p17n947rt.cloudfront.net/icon/9da5a168cf8194c8ee5ed192a443d563-674375b53bc8ae94f48cfdb5c81e8363.svg',\n" +
                "    \"remark\": \"数据运营治理服务\",\n" +
                "    \"updateTime\": null,\n" +
                "    \"title\": \"数据运营治理服务\",\n" +
                "    \"productItem\": [\n" +
                "      {\n" +
                "        \"addTime\": \"2021-07-23 04:56:00\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2021-07-23 04:56:11\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2023-02-15 15:01:56\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2022-12-21 14:53:10\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2021-07-23 04:55:48\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2023-03-16 16:49:16\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"addTime\": \"2021-07-23 04:56:23\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"addTime\": \"2023-05-02 05:14:31\",\n" +
                "    \"departmentId\": null,\n" +
                "    \"lastUpdateOperatorId\": null,\n" +
                "    \"usage\": 7,\n" +
                "    \"icon\": 'https://d1by4p17n947rt.cloudfront.net/icon/a5ffe5487f62ef75d8e5cf78c18525a5-d4867f9d4adcd749f0c5aff987232847.svg',\n" +
                "    \"remark\": \"技术研发组件服务\",\n" +
                "    \"updateTime\": null,\n" +
                "    \"title\": \"技术研发组件服务\",\n" +
                "    \"productItem\": [\n" +
                "      {\n" +
                "        \"addTime\": \"2021-07-23 04:53:46\",\n" +
                "        \"departmentId\": null,\n" +
                "        \"sortNumber\": 8,\n" +
                "        \"hasStatus\": 0,\n" +
                "        \"productBrief\": null,\n" +
                "        \"linkPath\": \"http://alinesno-notice.beta.linesno.com\",\n" +
                "        \"deleteManager\": null,\n" +
                "        \"itemStatus\": null,\n" +
                "        \"fieldProp\": null,\n" +
                "        \"id\": \"c230a72a7e1bb97c8d383a27327d7a77\",\n" +
                "        \"viewCount\": null,\n" +
                "        \"operatorId\": null,\n" +
                "        \"applicationName\": null,\n" +
                "        \"fieldId\": null,\n" +
                "        \"lastUpdateOperatorId\": \"784553886277959680\",\n" +
                "        \"banner\": null,\n" +
                "        \"updateTime\": \"2021-07-23 13:12:21\",\n" +
                "        \"productDescribe\": null,\n" +
                "        \"productTypeId\": \"787440246718464000\",\n" +
                "        \"hasInner\": 0,\n" +
                "        \"hasDelete\": 0,\n" +
                "        \"deleteTime\": null,\n" +
                "        \"subName\": null,\n" +
                "        \"prodStatus\": \"normal\",\n" +
                "        \"identityStatus\": null,\n" +
                "        \"tenantId\": \"0\",\n" +
                "        \"name\": \" 多渠道通知服务 \",\n" +
                "        \"hasRecommend\": 1,\n" +
                "        \"applicationId\": \"0\",\n" +
                "        \"shortName\": null\n" +
                "      },\n" +
                "      ...\n" + // 省略其他 productItem 的内容
                "    ],\n" +
                "    ...\n" + // 省略其他字段内容
                "  },\n" +
                "  ...\n" + // 省略其他 screenJsonList 的内容
                "]";

        return AjaxResult.success(screenJsonList);
    }


}
