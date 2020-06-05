package com.defy.jms.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.defy.jms.spring.config.AppConfig;
import com.defy.jms.spring.config.producer.MessageSender;

/**
 * Hello world!
 *
 */
public class MessageProducerApp
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		MessageSender messageSender = context.getBean(MessageSender.class);

		messageSender.sendMessage("Hi Peter, How are you?");
		System.out.println("Message has been sent successfully...");

		((AbstractApplicationContext) context).close();
	}

}