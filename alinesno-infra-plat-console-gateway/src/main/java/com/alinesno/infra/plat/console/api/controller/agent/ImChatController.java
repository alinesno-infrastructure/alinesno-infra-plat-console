package com.alinesno.infra.plat.console.api.controller.agent;

import cn.hutool.core.io.resource.ResourceUtil;
import com.alibaba.fastjson.JSONArray;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.rest.SuperController;
import com.alinesno.infra.plat.console.adapter.CloudStorageConsumer;
import com.alinesno.infra.plat.console.adapter.SmartBrainConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Slf4j
@RestController
@RequestMapping(value = "/v1/api/infra/base/im/chat/")
public class ImChatController extends SuperController {

    @Autowired
    private SmartBrainConsumer smartBrainConsumer;

    @Autowired
    private CloudStorageConsumer storageConsumer ;

    /**
     * 显示图片
     * @return
     */
    @GetMapping("/displayImage/{imageId}")
    public ResponseEntity<byte[]> displayImage(@PathVariable("imageId") String imageId){

        byte[] byteBody = null ;
        try{
            byteBody = storageConsumer.download(imageId , progress -> {}) ;
        }catch(Exception e){
            log.error("文件下载失败:{}" , e.getMessage());
            byteBody =  ResourceUtil.readBytes("default_avatar.jpeg") ;
        }

        return new ResponseEntity<>(byteBody, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * 获取所有频道列表
     * @return
     */
    @GetMapping("/getAllCatalog")
    public AjaxResult getAllCatalog(){
        return AjaxResult.success(smartBrainConsumer.getAllCatalog().getData()) ;
    }

}