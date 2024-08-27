package com.alinesno.infra.plat.console.adapter;

import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.facade.response.R;
import com.alinesno.infra.plat.console.api.MenuItem;
import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Post;
import org.apache.ibatis.annotations.Param;

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
    R<String> sayHello(@Param("accountId") long accountId);

    /**
     * 查询用户今天是否签到
     */
    @Get("/api/infra/base/platform/provider/account/isSignIn")
    R<Boolean> isSignIn(@Param("accountId")  long accountId);

    /**
     * 用户签到
     */
    @Get("/api/infra/base/platform/provider/account/signIn")
    R<Integer> signIn(@Param("accountId") long accountId);

    /**
     * 组织自定义视图查询
     */
    @Get("/api/infra/base/platform/provider/account/customView")
    R<List<MenuItem>> customView(@Param("orgId") long orgId);

    /**
     * 保存组织自定义视图查询
     */
    @Post("/api/infra/base/platform/provider/account/saveCustomView")
    R<Boolean> saveCustomView(@Body List<MenuItem> menuList);

}
