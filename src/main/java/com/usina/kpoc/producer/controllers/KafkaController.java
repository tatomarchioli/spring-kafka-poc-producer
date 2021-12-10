package com.usina.kpoc.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usina.kpoc.producer.TopicProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	@Autowired
    private TopicProducer topicProducer;
    
    @GetMapping (value = "/send")    
    public void send(){
        topicProducer.send("Mensagem de teste enviada ao tópico");
    }
    
}