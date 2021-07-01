package com.morlimoore.rabbitmqlistener.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.morlimoore.rabbitmqlistener.model.Person;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQListener implements MessageListener {


    @SneakyThrows
    public void onMessage(Message message) {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(message.getBody(), Person.class);
        log.info("Consuming Message - " + person);
    }

}
