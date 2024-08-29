package com.alinesno.infra.plat.console.config;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import com.dtflys.forest.springboot.annotation.ForestScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * 项目配置类
 */
@Slf4j
@EnableInfraSsoApi
@ForestScan(basePackages = "com.alinesno.infra.plat.console.adapter")
@Configuration
public class AppConfiguration implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("AppConfiguration.run {}", (Object) args);
    }
}
