package com.usina.kpoc.producer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usina.kpoc.producer.models.User;
import com.usina.kpoc.producer.producers.KafkaProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	
	@Autowired
    private KafkaProducer topicProducer;
    
    @GetMapping (value = "/send/{name}")    
    public void send(@PathVariable String name){
    	String[] nameArr = name.split(" ");
        topicProducer.send(
        		User.newBuilder()
        		.setName(nameArr[0])
        		.setAge(20)
        		.setSurname(nameArr[1])
        		.build());
    }
    
}