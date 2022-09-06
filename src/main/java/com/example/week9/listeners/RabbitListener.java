package com.example.week9.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RabbitListener {
    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "virtual-school.mark-updated")
    public void federalListener(String textMessage) {
        log.info("federals received " + textMessage);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(queues = "virtual-school.mark-updated-tg")
    public void telegramListener(String textMessage) {
        log.info("telegram received " + textMessage);
    }
}
