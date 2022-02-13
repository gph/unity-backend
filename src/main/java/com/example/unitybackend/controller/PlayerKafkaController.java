package com.example.unitybackend.controller;

import com.example.unitybackend.model.Player;
import com.example.unitybackend.service.PlayerKafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlayerKafkaController {
    private final PlayerKafkaProducer playerKafkaProducer;

    @PostMapping("api/v1/kafka/player/position")
    public void updatePlayerPosition(@RequestBody Player player) throws JsonProcessingException {
        System.out.println("KAFKA_PRODUCER controller -> " + player.getIgn() + " " + player.getPosition());
        playerKafkaProducer.send(player);
    }

}
