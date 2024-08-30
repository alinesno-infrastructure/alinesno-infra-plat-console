package com.alinesno.infra.plat.console.api.controller;

import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.response.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;

@Slf4j
@RestController
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/common")
public class ConsoleCommonController {

    /**
     * 接收图片文件并转换为Base64字符串
     *
     * @param file 图片文件
     * @return 包含Base64字符串的结果对象
     */
    @PostMapping("/upload")
    public AjaxResult upload(@RequestParam("file") MultipartFile file) {
        try {
            // 检查文件是否为空
            if (file.isEmpty()) {
                return AjaxResult.error("上传文件不能为空");
            }

            // 获取文件字节流
            byte[] bytes = file.getBytes();

            // 使用Base64进行编码
            String base64Encoded = Base64.getEncoder().encodeToString(bytes);

            // 返回成功结果，包含Base64字符串
            AjaxResult result =  AjaxResult.success(base64Encoded);
            result.put("fileName" , base64Encoded) ;

            return result ;
        } catch (Exception e) {
            // 处理异常情况
            return AjaxResult.error("文件上传失败：" + e.getMessage());
        }
    }
}