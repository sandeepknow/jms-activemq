package com.defy.jms.spring.config.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.defy.jms.spring.model.Product;

@Component
public class MessageReceiver implements MessageListener{

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	MessageConverter messageConverter;

	public void onMessage(Message message) {
		try {
			System.out.println("------- Inside onMessage-------");
			Product resProduct = (Product)messageConverter.fromMessage(message);
			System.out.println(resProduct);
			System.out.println("------- Inside onMessage-------");
		} catch (MessageConversionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
