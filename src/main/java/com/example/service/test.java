package com.example.service;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class test {
    //手动发送消息到MQ
    public static void main(String[] args){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setPort(5672);
        //connectionFactory.setVirtualHost("/");
        //connectionFactory.setPublisherConfirms(true);
        try {
            Connection connection =  connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            //channel.exchangeDeclare("dxx.direct","direct");
            channel.basicPublish("dxx.direct","test1",null,new String("第一次发送").getBytes());
            System.out.println(" [x] Sent '"+ "'");
            channel.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
    }
}
