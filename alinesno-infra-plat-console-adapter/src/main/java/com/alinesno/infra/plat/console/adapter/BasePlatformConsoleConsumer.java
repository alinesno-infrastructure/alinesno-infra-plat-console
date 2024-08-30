package com.alinesno.infra.plat.console.adapter;

import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.plat.console.api.FeedbackDto;
import com.alinesno.infra.plat.console.api.MenuItem;
import com.dtflys.forest.annotation.*;

import java.util.List;

/**
 * 平台消费者基类
 */
@BaseRequest(
        baseURL = "#{alinesno.infra.gateway.host}/base-platform" ,
        connectTimeout = 30*1000
)
public interface BasePlatformConsoleConsumer {

    /**
     * 打招呼信息
     */
    @Get("/api/infra/base/platform/provider/account/sayHello")
    R<String> getGreeting(@Query("accountId") long accountId);

    /**
     * 查询用户今天是否签到
     */
    @Get("/api/infra/base/platform/provider/account/isSignIn")
    R<Boolean> isSignIn(@Query("accountId")  long accountId);

    /**
     * 用户签到
     */
    @Get("/api/infra/base/platform/provider/account/signIn")
    R<Integer> signIn(@Query("accountId") long accountId);

    /**
     * 组织自定义视图查询
     */
    @Get("/api/infra/base/platform/provider/account/customView")
    R<List<MenuItem>> customView(@Query("orgId") long orgId);

    /**
     * 保存组织自定义视图查询
     */
    @Post("/api/infra/base/platform/provider/account/saveCustomView")
    R<Boolean> saveCustomView(@JSONBody List<MenuItem> menuList , @Query("orgId") long orgId);

    /**
     * 用户建立及反馈
     */
    @Post("/api/infra/base/platform/provider/account/saveFeedback")
    R<Boolean> saveFeedback(@JSONBody FeedbackDto dto);

}
