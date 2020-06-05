package com.defy.jms.spring.config.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void sendMessage(final String message) {
		
		jmsTemplate.send(new MessageCreator() {

			public Message createMessage(Session session) throws JMSException {
				
				Message objectMesage = session.createObjectMessage(message);
				return objectMesage;
			}
			
		});
		
	}
	

}
