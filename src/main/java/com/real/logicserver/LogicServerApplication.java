package com.real.logicserver;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;

/**
 * @author asuis
 */
@SpringBootApplication
public class LogicServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogicServerApplication.class, args);
	}

	
	
}
