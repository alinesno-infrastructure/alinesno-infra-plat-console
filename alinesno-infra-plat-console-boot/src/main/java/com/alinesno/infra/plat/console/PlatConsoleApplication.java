package com.alinesno.infra.plat.console;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 * @author LuoAnDong
 * @since 2023年8月3日 上午6:23:43
 */
@EnableInfraSsoApi
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PlatConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatConsoleApplication.class, args);
	}

}