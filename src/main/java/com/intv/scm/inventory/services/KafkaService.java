package com.intv.scm.inventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class KafkaService {

    @Autowired
    KafkaTemplate kafkaTemplate;

    public void inventoryDetails(String message) {
        kafkaTemplate.send("topicname",message);
    }

    @KafkaListener(topics = "topic name", groupId = "group")
    public void consume(String message) {
        //consume the message and continue with your logic
    }
}
