package com.example.week9.rabbitconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public CachingConnectionFactory connectionFactory(){
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate(){
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public FanoutExchange virtualSchoolExchange(){
        return new FanoutExchange("virtual-school");
    }

    @Bean
    public Queue federalMarksQueue(){
        return new Queue("virtual-school.mark-updated",true);
    }

    @Bean
    public Queue telegramMarksQueue(){
        return new Queue("virtual-school.mark-updated-tg",true);
    }

    @Bean
    public Binding federalBinding(){
        return BindingBuilder.bind(federalMarksQueue()).to(virtualSchoolExchange());
    }

    @Bean
    public Binding telegramBinding(){
        return BindingBuilder.bind(telegramMarksQueue()).to(virtualSchoolExchange());
    }

}
