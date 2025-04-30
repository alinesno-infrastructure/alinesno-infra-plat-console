package com.alinesno.infra.base.platform.console.controller;

import com.alinesno.infra.base.platform.adapter.BaseAuthorityConsumer;
import com.alinesno.infra.base.platform.api.MenuItemDto;
import com.alinesno.infra.base.platform.api.dto.ProductItemDto;
import com.alinesno.infra.base.platform.api.dto.SolutionDto;
import com.alinesno.infra.base.platform.console.FeedbackDto;
import com.alinesno.infra.base.platform.console.tools.TimePeriodTool;
import com.alinesno.infra.base.platform.entity.FeedbackEntity;
import com.alinesno.infra.base.platform.service.*;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.base.dto.OrganizationDto;
import com.alinesno.infra.common.web.adapter.login.account.CurrentAccountJwt;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
    private BaseAuthorityConsumer authorityConsumer;

    @Autowired
    private IAccountSignService accountSignService ;

    @Autowired
    private IProductItemService productItemService;

    @Autowired
    private IAccountPropertiesService accountPropertiesService ;

    @Autowired
    private IFeedbackService feedbackService ;

    @Autowired
    private ISolutionManageService solutionManageService;

    /**
     * 保存用户反馈记录
     */
    @PostMapping("/feedback")
    public AjaxResult feedback(@RequestBody FeedbackDto feedback) {

        long accountId = CurrentAccountJwt.getUserId();;
        long orgId = CurrentAccountJwt.get().getOrgId();;

        feedback.setAccountId(accountId);
        feedback.setOrgId(orgId);

        log.debug("--->>>>> = feedback = {}" , feedback);

        FeedbackEntity entity = new FeedbackEntity() ;
        BeanUtils.copyProperties(feedback, entity);

        feedbackService.save(entity) ;

        return AjaxResult.success() ;
    }

    /**
     * 生成视图列表
     */
    @GetMapping("/viewList")
    public AjaxResult getViewList() {
        long orgId = CurrentAccountJwt.get().getOrgId();;

        List<MenuItemDto> menuList = accountPropertiesService.queryConstomView(orgId) ;

        if(menuList == null || menuList.isEmpty()){
            menuList = new ArrayList<>();
            menuList.add(new MenuItemDto(0, "fa-brands fa-slack", "仪盘表", "0", "/index", "运营自动化门户"));
            menuList.add(new MenuItemDto(0, "fa-solid fa-rocket", "大模型套件", "2", "/dashboard/dataWorkspace", "数据治理开发治理"));
            menuList.add(new MenuItemDto(0, "fa-solid fa-pen-ruler", "业务基础套件", "1", "/dashboard/businessWorkspace", "公共的业务建设组件服务"));
            menuList.add(new MenuItemDto(0, "fas fa-feather fa-fw", "自定义套件", "5", "/dashboard/customWorkspace", "个性化服务视图配置"));
        }

        return AjaxResult.success(menuList);
    }

    /**
     * 获取推荐的应用
     */
    @GetMapping("/getRecommendedProducts")
    public AjaxResult getRecommendedProducts() {
        List<ProductItemDto> list = productItemService.recommendedProducts() ;
        return AjaxResult.success("操作成功." , list);
    }

    /**
     * 获取最新的解决方案
     */
    @GetMapping("/getNewSolution")
    public AjaxResult getNewSolution() {
        int count = 3 ;
        List<SolutionDto> result = solutionManageService.getNewSolution(count);
        return AjaxResult.success("操作成功." , result);
    }

    /**
     * 打招呼方法
     */
    @GetMapping("/getGreeting")
    public AjaxResult getGreeting() {
        long accountId = CurrentAccountJwt.getUserId() ;
        String greeting = accountSignService.sayHello(accountId) ;
        return AjaxResult.success("操作成功." , greeting);
    }

    /**
     * 更新用户视图
     */
    @PostMapping("/updateViewList")
    public AjaxResult updateViewList(@RequestBody List<MenuItemDto> menuList) {
        log.debug("--->>>>> = newMenusList = {}", menuList);

        long orgId = CurrentAccountJwt.get().getOrgId(); ;
        accountPropertiesService.saveCustomView(menuList , orgId) ;

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
        String imageUrl = "http://data.linesno.com/logo_2.png"; // 图片的 URL
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
        long accountId = CurrentAccountJwt.getUserId() ;
//        int signInDay = platformConsoleConsumer.signIn(accountId).getData() ;
        int signInDay = accountSignService.signIn(accountId);
        return AjaxResult.success("签到成功." , signInDay);
    }

    /**
     * 保存组织自定义主题
     */
    @PostMapping("/updateOrgCustomTheme")
    public AjaxResult updateOrgCustomTheme(@RequestBody OrganizationDto dto) {

        long orgId = CurrentAccountJwt.get().getOrgId();

        dto.setId(orgId);
        authorityConsumer.updateOrg(dto);

        return AjaxResult.success() ;
    }

    /**
     * 创建组织 createOrg
     */
    @PostMapping("/createOrg")
    public AjaxResult createOrg(@RequestBody OrganizationDto dto) {

        authorityConsumer.createOrJoinOrg(dto , CurrentAccountJwt.getUserId());

        return AjaxResult.success() ;
    }

    /**
     * 查询用户所在组织信息
     */
    @GetMapping("/findOrg")
    public AjaxResult findOrg() {

        long orgId = CurrentAccountJwt.get().getOrgId();
        log.debug("--->>>>> = orgId = {}" , orgId);

        OrganizationDto dto = authorityConsumer.findOrg(orgId).getData() ;
        return AjaxResult.success(dto);
    }


}
