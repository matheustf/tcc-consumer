package com.puc.tcc.consumer.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.puc.tcc.consumer.rabbitmq.listener.Receiver;

@Configuration
public class RabbitMQConfig implements RabbitListenerConfigurer {
	
	@Autowired
	private Receiver receiver;

	public static final String ROUTING_ENTREGA = "my.queue.entregas";
	public static final String ROUTING_AVALIACOES = "my.queue.avaliacoes";
	public static final String ROUTING_PEDIDOS = "my.queue.pedidos";
	
	@Bean
	Queue queueEntregas() {
		return new Queue(ROUTING_ENTREGA, true);
	}
	
	@Bean
	Queue queueAvaliacoes() {
		return new Queue(ROUTING_AVALIACOES, true);
	}
	
	@Bean
	Queue queuePedidos() {
		return new Queue(ROUTING_PEDIDOS, true);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange("my_queue_exchange");
	}
	
	@Bean
	public MappingJackson2MessageConverter jackson2Converter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		return converter;
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(jackson2Converter());
		return factory;
	}

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
	}

}
