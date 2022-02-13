package com.example.unitybackend.service;

import com.example.unitybackend.model.Player;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class PlayerKafkaConsumer {
    @Value("${topic.name.producer}")
    private String topicName;

    private final PlayerService playerService;

    @KafkaListener(topics = "${topic.name.producer}", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> payload) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Player player = mapper.readValue(payload.value(), Player.class);
        System.out.println("KAFKA_CONSUMER " + player);
        playerService.updatePlayerPosition(player);
    }
}
