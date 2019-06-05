package com.example.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender_Direct{
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 给hello队列发送消息
     */
    public void send() {
            rabbitTemplate.convertAndSend("dxx.direct","test1","2019.6.5 14:07");

    }
}
