package com.defy.jms.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.defy")
@Import({ MessagingConfiguration.class })
public class AppConfig {

}
