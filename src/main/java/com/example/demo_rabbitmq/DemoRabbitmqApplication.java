package com.example.demo_rabbitmq;

import com.example.demo_rabbitmq.config.AMQPProducer;
import com.rabbitmq.client.AMQP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class DemoRabbitmqApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoRabbitmqApplication.class, args);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.asList(beanDefinitionNames).forEach(s -> System.out.println(s));
        AMQPProducer amqpProducer = context.getBean("AMQPProducer", AMQPProducer.class);
        amqpProducer.sendMessage(new Notification("A", "B"));
    }

}
