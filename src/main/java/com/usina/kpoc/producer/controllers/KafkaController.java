package com.usina.kpoc.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usina.kpoc.producer.models.User;
import com.usina.kpoc.producer.producers.KafkaProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	@Autowired
    private KafkaProducer topicProducer;
    
    @GetMapping (value = "/send")    
    public void send(){
    	
        topicProducer.send(new User("teste", 20));
    }
    
}