package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	  @Bean
	    public Queue taskQueue() {
	        return new Queue("taskQueue");
	    }

	    @Bean
	    public DirectExchange taskExchange() {
	        return new DirectExchange("taskExchange");
	    }

	    @Bean
	    public Binding binding(Queue taskQueue, DirectExchange taskExchange) {
	        return BindingBuilder.bind(taskQueue).to(taskExchange).with("taskRoutingKey");
	    }
	    @Bean
	    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
	        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
	        return rabbitTemplate;
	    }
}
