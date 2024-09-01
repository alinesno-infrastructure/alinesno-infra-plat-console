package com.alinesno.infra.plat.console.api.controller.agent;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.plat.console.adapter.BasePlatformProductConsumer;
import com.alinesno.infra.plat.console.adapter.dto.AgentChannelDto;
import com.alinesno.infra.plat.console.adapter.dto.AgentChannelResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 处理与BusinessLogEntity相关的请求的Controller。
 * 继承自BaseController类并实现IBusinessLogService接口。
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/im/channel")
public class ChannelController {

    @Autowired
    private BasePlatformProductConsumer platformProductConsumer ;

    /**
     * 查询出我所有的渠道
     * @return
     */
    @GetMapping("/allMyChannel")
    public AjaxResult allMyChannel(){
        AgentChannelResponse data = platformProductConsumer.queryAllAgentChannel().getData() ;

        AjaxResult result = AjaxResult.success() ;
        result.put("recommend",data.getRecommendChannels()) ;
        result.put("public",data.getSpecificChannels()) ;

        return result ;
    }

}

