package com.defy.jms.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.defy.jms.spring.config.AppConfig;
import com.defy.jms.spring.config.producer.ProductMessageSender;
import com.defy.jms.spring.model.Product;

/**
 * Hello world!
 *
 */
public class ProductMsgProducerApp
{

	public static void main(String[] args)
	{
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		ProductMessageSender messageSender = context.getBean(ProductMessageSender.class);

		Product product = new Product();
		product.setProductId(100);
		product.setName("Laptop");
		product.setQuantity(10);
		
		messageSender.sendMessage(product);
		System.out.println("Product has been sent successfully...");

		((AbstractApplicationContext) context).close();
	}

}