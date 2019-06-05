package com.example.service;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
//手动接收mq消息
public class test2 {
    public static void main(String[] args){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);

        //获得连接和mq通道
        Connection connection = null;
        try {
            connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            //声明通道
            //channel.queueDeclare("test",false,false,false,null);
            //绑定exchange
            //channel.queueBind("","","item.#");//使用item.# 匹配所有的以item开头的
            //同一时刻服务器只能发送一条消息给消费者；
            channel.basicQos(1);
            //声明消费者,直接在下面的监控中做
            GetResponse response = channel.basicGet("test",false);
            if (response ==null) {
                System.out.println("该队列暂时没有消息收到");
                // No message retrieved.
            }else {
                AMQP.BasicProperties props = response.getProps();
                byte[] body = response.getBody();
                String message = new String(body, "UTF-8");
                System.out.println("搜索系统 '" + message + "'");
                long deliveryTag = response.getEnvelope().getDeliveryTag();
                channel.basicAck(deliveryTag, false);// acknowledge receipt of the message
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
