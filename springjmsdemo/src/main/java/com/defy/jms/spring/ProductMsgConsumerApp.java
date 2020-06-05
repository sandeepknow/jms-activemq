package com.defy.jms.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.defy.jms.spring.config.AppConfig;
import com.defy.jms.spring.config.receiver.ProductMessageReceiver;
import com.defy.jms.spring.model.Product;

public class ProductMsgConsumerApp
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		ProductMessageReceiver productReceiver = (ProductMessageReceiver) context.getBean("productMessageReceiver");
		Product response = productReceiver.receiveMessage();
		System.out.println("Product Received = " + response);

		((AbstractApplicationContext) context).close();
	}

}