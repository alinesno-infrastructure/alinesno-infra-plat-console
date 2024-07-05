package com.alinesno.infra.plat.console.api.controller.agent;

import com.alibaba.fastjson.JSONArray;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/infra/base/im/chat/")
public class ImChatController extends SuperController {


    /**
     * 获取到消息信息
     * @return
     */
    @GetMapping("/chatMessage")
    public AjaxResult chatMessage(String channelId){

        String json = "[\n" +
                "        {\n" +
                "            \"channelId\": 0,\n" +
                "            \"roleType\": \"person\",\n" +
                "            \"icon\": \"1808349924122877953\",\n" +
                "            \"name\": \"软件工程师罗小东\",\n" +
                "            \"dateTime\": \"2024-07-03 12:04:03\",\n" +
                "            \"chatText\": \"<span class=\\\"mention\\\">@软文编辑(目录大纲)</span><span class=\\\"mention-text\\\">编写一份解决方案目录\\n</span>\",\n" +
                "            \"readerType\": \"html\",\n" +
                "            \"businessId\": \"0\",\n" +
                "            \"className\": null,\n" +
                "            \"loading\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"channelId\": 0,\n" +
                "            \"roleType\": \"agent\",\n" +
                "            \"icon\": \"1808350214041559041\",\n" +
                "            \"name\": \"软文编辑(目录大纲)\",\n" +
                "            \"dateTime\": \"2024-07-03 12:04:03\",\n" +
                "            \"chatText\": \"收到，任务我已经在处理，请稍等1-2分钟 :-)\",\n" +
                "            \"readerType\": \"html\",\n" +
                "            \"businessId\": \"1808350967470592000\",\n" +
                "            \"className\": null,\n" +
                "            \"loading\": false\n" +
                "        },\n" +
                "        {\n" +
                "            \"channelId\": 0,\n" +
                "            \"roleType\": \"agent\",\n" +
                "            \"icon\": \"1808350214041559041\",\n" +
                "            \"name\": \"软文编辑(目录大纲)\",\n" +
                "            \"dateTime\": \"2024-07-03 12:04:12\",\n" +
                "            \"chatText\": \"### <i class='fa-brands fa-redhat'></i> 任务已经处理\\n- 任务: 执行简单业务服务任务类型 \\n- 业务标识: 1808350967470592000\\n- 持续时间: 46秒503\\n- <i class='fa-solid fa-file-pdf'></i> 内容: <a href='#'>查看生成结果</a>\\n- <i class='fa-solid fa-vial-circle-check'></i> 状态: 完成\\n- <i class='fa-solid fa-hourglass-end'></i> 完成时间: 2024-07-03 12:04:12\\n- <i class='fa-solid fa-user-secret'></i> 执行人:软文编辑(目录大纲)\\n\",\n" +
                "            \"readerType\": null,\n" +
                "            \"businessId\": \"1808350967470592000\",\n" +
                "            \"className\": null,\n" +
                "            \"loading\": false\n" +
                "        }\n" +
                "    ]" ;

        return AjaxResult.success(JSONArray.parseArray(json)) ;
    }

    /**
     * 轮训任务结果，这里假设并发不高的情况下执行
     * TODO 后续再进一步优化
     * @return
     */
    @GetMapping("/getTaskNotice")
    public AjaxResult getTaskNotice(){
        return AjaxResult.success("查询成功" , new ArrayList<>()) ;
    }

    /**
     * 获取到频道的Agent列表
     * @return
     */
    @GetMapping("/getChannelAgent")
    public AjaxResult getChannelAgent(String channelId){

        String json = "[\n" +
                "        {\n" +
                "            \"id\": \"1744724806304976898\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": null,\n" +
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
                "            \"accountType\": 0,\n" +
                "            \"accountId\": null,\n" +
                "            \"accountName\": null,\n" +
                "            \"avatar\": \"1808350214041559041\",\n" +
                "            \"status\": null,\n" +
                "            \"agentId\": null,\n" +
                "            \"roleName\": \"软文编辑(目录大纲)\",\n" +
                "            \"industry\": null,\n" +
                "            \"responsibilities\": \"软文推广(目录大纲)编写\",\n" +
                "            \"skills\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"salaryRange\": null,\n" +
                "            \"education\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"chainId\": \"1745079705807015937\",\n" +
                "            \"promptId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1744724952044457986\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": null,\n" +
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
                "            \"accountType\": 0,\n" +
                "            \"accountId\": null,\n" +
                "            \"accountName\": null,\n" +
                "            \"avatar\": \"1808350176838082561\",\n" +
                "            \"status\": null,\n" +
                "            \"agentId\": null,\n" +
                "            \"roleName\": \"软文编辑(文案编写)\",\n" +
                "            \"industry\": null,\n" +
                "            \"responsibilities\": \"软文推广(文案编写)\",\n" +
                "            \"skills\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"salaryRange\": null,\n" +
                "            \"education\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"chainId\": \"1745079855849852929\",\n" +
                "            \"promptId\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": \"1744726036628557825\",\n" +
                "            \"fieldProp\": null,\n" +
                "            \"addTime\": null,\n" +
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
                "            \"accountType\": 0,\n" +
                "            \"accountId\": null,\n" +
                "            \"accountName\": null,\n" +
                "            \"avatar\": \"1808350152938938369\",\n" +
                "            \"status\": null,\n" +
                "            \"agentId\": null,\n" +
                "            \"roleName\": \"代码生成专家\",\n" +
                "            \"industry\": null,\n" +
                "            \"responsibilities\": \"根据数据库生成代码结构\",\n" +
                "            \"skills\": null,\n" +
                "            \"experience\": null,\n" +
                "            \"roleLevel\": \"高级工程师\",\n" +
                "            \"salaryRange\": null,\n" +
                "            \"education\": null,\n" +
                "            \"otherAttributes\": null,\n" +
                "            \"chainId\": null,\n" +
                "            \"promptId\": null\n" +
                "        }\n" +
                "    ]" ;

        return AjaxResult.success(JSONArray.parseArray(json)) ;
    }

    /**
     * 显示图片
     * @return
     */
    @GetMapping("/displayImage/{imageId}")
    public ResponseEntity<byte[]> displayImage(@PathVariable("imageId") String imageId) throws IOException {

        URL httpUrl = new URL("http://alinesno-infra-base-im-ui.beta.base.infra.linesno.com/prod-api/v1/api/infra/base/im/chat/displayImage/" + imageId);
        HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();
        byte[] byteBody = IOUtils.toByteArray(conn) ;

        return new ResponseEntity<>(byteBody, new HttpHeaders(), HttpStatus.OK);
    }

}