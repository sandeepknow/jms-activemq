package com.defy.jms.spring.config.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.defy.jms.spring.model.Product;

@Component
public class MessageReceiver {

	private static final String MESSAGE_QUEUE = "message_queue";

	@JmsListener(destination = MESSAGE_QUEUE)
	public String receiveMessage(final Message<Product> message) {

		MessageHeaders headers = message.getHeaders();
		System.out.println("Headers " + headers);

		Product product = message.getPayload();
		System.out.println("Product " + product);

		return null;
	}
}
