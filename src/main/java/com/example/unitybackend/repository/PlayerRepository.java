package com.example.unitybackend.repository;

import com.example.unitybackend.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {
    Player findPlayerByIgn(String ign);
}
