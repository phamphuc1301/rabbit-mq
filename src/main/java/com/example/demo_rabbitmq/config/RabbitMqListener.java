package com.example.demo_rabbitmq.config;

import com.example.demo_rabbitmq.Notification;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqListener {

    @RabbitListener(queues="${rabbitmq.queueName}")
    public void listen(byte[] message) {
        String msg = new String(message);
        Notification not = new Gson().fromJson(msg, Notification.class);
        System.out.println("Received a new notification...");
        System.out.println(not.toString());
    }
}