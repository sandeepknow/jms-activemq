package com.defy.jms.spring.config;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

@Configuration
@EnableJms
public class MessagingListenerConfiguration {
	
	@Autowired
	ConnectionFactory connectionFactory;

	@Bean
	MessageListenerContainer getContainer() {
		DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setConcurrency("1-1");
		return container;
		
	}

}
