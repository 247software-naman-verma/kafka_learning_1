package com.example.demo2.controller;

import com.example.demo2.config.KafkaConfig;
import com.example.demo2.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private KafkaConfig kafkaConfig;

    public KafkaProducerController(KafkaProducer kafkaProducer, KafkaConfig kafkaConfig) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaConfig = kafkaConfig;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("topic") String topic, @RequestParam("message") String message){
        if (kafkaConfig.isValidTopic(topic)) {
            kafkaProducer.sendMessage(topic, message);
            return ResponseEntity.ok("Message sent to kafka topic: "+topic);
        } else {
            return ResponseEntity.badRequest().body("Invalid topic. Please provide a valid topic.");
        }
    }
}