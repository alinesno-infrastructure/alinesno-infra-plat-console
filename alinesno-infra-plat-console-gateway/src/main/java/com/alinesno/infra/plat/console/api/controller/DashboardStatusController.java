package com.alinesno.infra.plat.console.api.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.plat.console.adapter.BasePlatformConsoleConsumer;
import com.alinesno.infra.plat.console.api.FeedbackDto;
import com.alinesno.infra.plat.console.api.MenuItem;
import com.alinesno.infra.plat.console.api.tools.CheckinUtils;
import com.alinesno.infra.plat.console.api.tools.TimePeriodTool;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

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

    @Autowired
    private BasePlatformConsoleConsumer platformConsoleConsumer ;

    /**
     * 保存用户反馈记录
     */
    @PostMapping("/feedback")
    public AjaxResult feedback(@RequestBody FeedbackDto feedback) {
        log.debug("--->>>>> = feedback = {}" , feedback);

        return AjaxResult.success("反馈成功");
    }

    /**
     * 生成视图列表
     */
    @GetMapping("/viewList")
    public AjaxResult getViewList() {

        log.debug("--->>>>> = StpUtil = {}" , CurrentAccountJwt.isLogin());
        long orgId = 1L ;

        List<MenuItem> menuList = platformConsoleConsumer.customView(orgId).getData() ;

        if(menuList == null || menuList.isEmpty()){
            menuList = new ArrayList<>();

            menuList.add(new MenuItem(0, "fa-brands fa-slack", "仪盘表", "0", "/index", "运营自动化门户"));
            menuList.add(new MenuItem(0, "fa-solid fa-pen-ruler", "研发服务", "1", "/dashboard/businessWorkspace", "公共的业务建设组件服务"));
            menuList.add(new MenuItem(0, "fa-solid fa-rocket", "数据治理", "2", "/dashboard/dataWorkspace", "数据治理开发治理"));
            menuList.add(new MenuItem(0, "fa-solid fa-sailboat", "智能服务", "3", "/dashboard/smartWorkspace", "智能化专家服务"));
            menuList.add(new MenuItem(0, "fas fa-shipping-fast", "运营服务", "4", "/dashboard/operationWorkspace", "整体服务的运营监控"));
            menuList.add(new MenuItem(0, "fas fa-feather fa-fw", "自定义服务", "5", "/dashboard/customWorkspace", "个性化服务视图配置"));
        }

        return AjaxResult.success(menuList);
    }

    /**
     * 打招呼方法
     */
    @GetMapping("/getGreeting")
    public AjaxResult getGreeting() {
        long accountId = 1L ;
        String greeting = platformConsoleConsumer.getGreeting(accountId).getData() ;
        return AjaxResult.success("操作成功." , greeting);
    }

    /**
     * 更新用户视图
     */
    @PostMapping("/updateViewList")
    public AjaxResult updateViewList(@RequestBody List<MenuItem> menuList) {
        log.debug("--->>>>> = newMenusList = {}", menuList);

        long orgId = 1L ;
        Boolean b =  platformConsoleConsumer.saveCustomView(menuList , orgId).getData();

        return AjaxResult.success("更新视图成功");
    }

    /**
     * 获取当前时间段
     */
    @GetMapping("/current-time-period")
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
    @RequestMapping("/daySignIn")
    public AjaxResult daySignIn() {
        long accountId = 1L ;
        int signInDay = platformConsoleConsumer.signIn(accountId).getData() ;
        return AjaxResult.success("签到成功." , signInDay);
    }

}
