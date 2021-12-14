package com.usina.kpoc.producer.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.usina.kpoc.producer.models.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KafkaProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(User message){
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }

}