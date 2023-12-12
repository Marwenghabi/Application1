package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;

@Service
public class TaskService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendTask(Task task) {
        rabbitTemplate.convertAndSend("taskExchange", "taskRoutingKey", task);
    }
}