package com.defy.jms.spring.config.receiver;

import javax.jms.JMSException;
import javax.jms.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.defy.jms.spring.model.Product;

@Component
public class ProductMessageReceiver {

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	MessageConverter messageConverter;

	public Product receiveMessage() {

		try {
			Message message = jmsTemplate.receive();
			Product resProduct = (Product)messageConverter.fromMessage(message);
			return resProduct;
		} catch (MessageConversionException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		return null;
	}
}
