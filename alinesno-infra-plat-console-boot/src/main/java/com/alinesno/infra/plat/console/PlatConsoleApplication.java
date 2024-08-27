package com.alinesno.infra.plat.console;

import com.alinesno.infra.common.web.adapter.sso.enable.EnableInfraSsoApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 集成一个Java开发示例工具
 *
 * @author luoxiaodong
 * @version 1.0.0
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class PlatConsoleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatConsoleApplication.class, args);
	}

}