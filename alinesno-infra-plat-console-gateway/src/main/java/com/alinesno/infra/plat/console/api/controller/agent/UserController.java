package com.alinesno.infra.plat.console.api.controller.agent;

import com.alibaba.fastjson.JSONArray;
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
@RequestMapping("/api/infra/base/im/user")
public class UserController {

    /**
     * 获取BusinessLogEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        JSONArray array = JSONArray.parseArray("[\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2023-12-29 19:58:21\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"数据库设计专家，用于数据库设计\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1740825027536683010\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349692358221826\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2023-12-29 19:58:21\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1740826360738152450\",\n" +
                "            \"industryCatalog\": \"1744655683264892929\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"数据库设计专家\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2023-12-29 19:58:21\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求拆分和编写\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1740825311486869506\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349647059738625\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2023-12-29 19:58:21\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1740826553479004162\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求编写分析师\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2023-12-30 09:47:29\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"用于服务工程生成专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1741645078294921218\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349728060137473\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2023-12-30 09:47:29\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1741645177548931074\",\n" +
                "            \"industryCatalog\": \"1744655683264892929\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"服务工程生成专家\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:23:22\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"用于平台菜单生成专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1741646329840406530\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349751040729090\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-03 10:51:46\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": null,\n" +
                "            \"industryCatalog\": \"1744655683264892929\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"项目菜单生成专家\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求分析_需求文档分析专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1742372214781972481\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349774163927042\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1742415269484498945\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求分析(需求文档分析专家)\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求分析_项目介绍分析专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1742372307912298497\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349808288784386\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1742415392373411841\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求分析(项目介绍分析专家)\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求分析_项目功能分析专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1742372385792135169\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349839242747906\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1742415455845814273\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求分析(项目功能分析专家)\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求分析_项目功能细化分析专家\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1742372831223025666\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808349886575468546\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1742415517179121666\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求分析(项目功能细化分析专家)\",\n" +
                "            \"applicationId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"education\": null,\n" +
                "            \"addTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"departmentId\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"skills\": null,\n" +
                "            \"hasStatus\": 0,\n" +
                "            \"responsibilities\": \"需求分析_项目非功能性需求\",\n" +
                "            \"deleteManager\": null,\n" +
                "            \"fieldProp\": null,\n" +
                "            \"id\": \"1742372920440066049\",\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"dataSourceApi\": null,\n" +
                "            \"operatorId\": null,\n" +
                "            \"applicationName\": null,\n" +
                "            \"fieldId\": null,\n" +
                "            \"salaryRange\": null,\n" +
                "            \"roleAvatar\": \"1808350238808924161\",\n" +
                "            \"lastUpdateOperatorId\": null,\n" +
                "            \"updateTime\": \"2024-01-01 02:39:30\",\n" +
                "            \"hasDelete\": 0,\n" +
                "            \"deleteTime\": null,\n" +
                "            \"chainId\": \"1742415641032724482\",\n" +
                "            \"industryCatalog\": \"1742481225890758657\",\n" +
                "            \"promptId\": null,\n" +
                "            \"tenantId\": \"0\",\n" +
                "            \"roleName\": \"需求分析(项目非功能性需求)\",\n" +
                "            \"applicationId\": null\n" +
                "        }\n" +
                "    ]") ;

        TableDataInfo info = new TableDataInfo();
        info.setRows(array);

        return info ;
    }

    /**
     * 添加用户到当前的频道当中
     * @return
     */
    @GetMapping("/addChainAgent")
    public AjaxResult addChainAgent(Long channelId , Long roleId){



        return AjaxResult.success() ;
    }

    /**
     * 运行角色流程
     * @return
     */
    @GetMapping("/listAllUser")
    public AjaxResult listAllUser(String channelId){
        return AjaxResult.success() ;
    }

}

