package com.alinesno.infra.plat.console.api.controller.agent;

import cn.hutool.core.util.IdUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.facade.response.AjaxResult;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
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

    /**
     * 获取BusinessLogEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
//    @ResponseBody
//    @PostMapping("/datatables")
//    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
//        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
//        return this.toPage(model, this.getFeign(), page);
//    }

    /**
     * createChannel
     * @return
     */
    @PostMapping("/createChannel")
    public AjaxResult createChannel(){
        return AjaxResult.success("操作成功") ;
    }

    /**
     * 逻辑删除聊天窗口
     * @return
     */
    @DeleteMapping("/removeChannel")
    public AjaxResult removeChannel(Long channelId){


        return AjaxResult.success() ;
    }

    @GetMapping("/detail/{id}")
    public AjaxResult detail(){

        String json = "{\n" +
                "        \"id\": \"1808350827032711169\",\n" +
                "        \"fieldProp\": null,\n" +
                "        \"addTime\": \"2024-02-06 21:29:26\",\n" +
                "        \"deleteTime\": null,\n" +
                "        \"hasStatus\": 0,\n" +
                "        \"updateTime\": null,\n" +
                "        \"operatorId\": null,\n" +
                "        \"lastUpdateOperatorId\": null,\n" +
                "        \"hasDelete\": 0,\n" +
                "        \"deleteManager\": null,\n" +
                "        \"applicationId\": null,\n" +
                "        \"applicationName\": null,\n" +
                "        \"tenantId\": \"0\",\n" +
                "        \"fieldId\": null,\n" +
                "        \"departmentId\": null,\n" +
                "        \"channelDesc\": \"解决方案编写频道\",\n" +
                "        \"icon\": \"1808350773008064514\",\n" +
                "        \"channelId\": \"8k2lePUJqU2mkfbydsKCo\",\n" +
                "        \"channelName\": \"解决方案编写频道\",\n" +
                "        \"channelType\": \"2\",\n" +
                "        \"channelKey\": null\n" +
                "    }" ;

        return AjaxResult.success(JSONObject.parseObject(json)) ;
    }

    /**
     * 获取到用户默认的频道
     * @return
     */
    @GetMapping("/getDefaultChannelId")
    public AjaxResult getDefaultChannelId(){
        Long channelId = 1808350827032711169L;
        return AjaxResult.success("操作成功." , channelId) ;
    }

    /**
     * 查询出我所有的渠道
     * @return
     */
    @GetMapping("/allMyChannel")
    public AjaxResult allMyChannel(){

        String json = "[\n" +
                "        {\n" +
                "            \"id\": \"1746670324599959553\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": \"2024-01-14 10:09:41\",\n" +
                "            \"deleteTime\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"updateTime\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteManager\": null,\n" +
                "            \"applicationId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"fieldId\": null,\n" +
                "            \"departmentId\": null,\n" +
                "            \"channelDesc\": \"公共频道服务，用于公共交流\",\n" +
                "            \"icon\": \"1746473582053335042\",\n" +
                "            \"channelId\": \"21WElQLlNLUPrg0RWASHp\",\n" +
                "            \"channelName\": \"个人公共频道\",\n" +
                "            \"channelType\": \"1\",\n" +
                "            \"channelKey\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1808350827032711169\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": \"2024-02-06 21:29:26\",\n" +
                "            \"deleteTime\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"updateTime\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteManager\": null,\n" +
                "            \"applicationId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"fieldId\": null,\n" +
                "            \"departmentId\": null,\n" +
                "            \"channelDesc\": \"解决方案编写频道\",\n" +
                "            \"icon\": \"1808350773008064514\",\n" +
                "            \"channelId\": \"8k2lePUJqU2mkfbydsKCo\",\n" +
                "            \"channelName\": \"解决方案编写频道\",\n" +
                "            \"channelType\": \"2\",\n" +
                "            \"channelKey\": null\n" +
                "        }\n" +
                "    ]" ;

        return AjaxResult.success(JSONArray.parseArray(json)) ;
    }

    /**
     * 查看所有的公开频道
     * @return
     */
    @GetMapping("/allPublicChannel")
    public AjaxResult allPublicChannel(){

        String json = "[\n" +
                "        {\n" +
                "            \"id\": \"1746670324599959553\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": \"2024-01-14 10:09:41\",\n" +
                "            \"deleteTime\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"updateTime\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteManager\": null,\n" +
                "            \"applicationId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"fieldId\": null,\n" +
                "            \"departmentId\": null,\n" +
                "            \"channelDesc\": \"公共频道服务，用于公共交流\",\n" +
                "            \"icon\": \"1746473582053335042\",\n" +
                "            \"channelId\": \"21WElQLlNLUPrg0RWASHp\",\n" +
                "            \"channelName\": \"个人公共频道\",\n" +
                "            \"channelType\": \"1\",\n" +
                "            \"channelKey\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1808350827032711169\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": \"2024-02-06 21:29:26\",\n" +
                "            \"deleteTime\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"updateTime\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteManager\": null,\n" +
                "            \"applicationId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"fieldId\": null,\n" +
                "            \"departmentId\": null,\n" +
                "            \"channelDesc\": \"解决方案编写频道\",\n" +
                "            \"icon\": \"1808350773008064514\",\n" +
                "            \"channelId\": \"8k2lePUJqU2mkfbydsKCo\",\n" +
                "            \"channelName\": \"解决方案编写频道\",\n" +
                "            \"channelType\": \"2\",\n" +
                "            \"channelKey\": null\n" +
                "        }\n" +
                "    ]" ;

        return AjaxResult.success(JSONArray.parseArray(json)) ;
    }

    /**
     * 加入频道
     * @param channelId
     * @return
     */
    @GetMapping("/joinChannel")
    public AjaxResult joinChannel(String channelId){

        long userId = IdUtil.getSnowflakeNextId() ;

        return AjaxResult.success() ;
    }

}

