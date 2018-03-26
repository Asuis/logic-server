package com.real.logicserver;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author asuis
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LogicServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogicServerApplication.class, args);
	}
}
