package com.example.unitybackend.service;

import com.example.unitybackend.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerKafkaProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(Player player) throws JsonProcessingException {
        System.out.println("KAFKA_PRODUCER send -> " + player.getIgn());
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(player);
        kafkaTemplate.send(topicName, result);
    }
}
