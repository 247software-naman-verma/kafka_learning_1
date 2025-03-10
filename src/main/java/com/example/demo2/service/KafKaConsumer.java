package com.example.demo2.service;

import com.example.demo2.utils.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafKaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafKaConsumer.class);

    @KafkaListener(topics = {AppConstants.TOPIC_INCIDENTS,AppConstants.TOPIC_ACTIVITY},
            groupId = AppConstants.GROUP_ID)
    public void consume(String message){
        LOGGER.info(String.format("Message received -> %s", message));
    }
}