package com.example.unitybackend.service;

import com.example.unitybackend.model.Player;
import com.example.unitybackend.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public void addPlayer(Player player) {
        playerRepository.insert(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayer(String ign) {
        return playerRepository.findPlayerByIgn(ign);
    }

    public void updatePlayerPosition(Player player) {
        Player temp = playerRepository.findPlayerByIgn(player.getIgn());
        if(temp == null)
            return;
        if(temp.getId() == null)
            return;

        temp.setPosition(player.getPosition());
        playerRepository.save(temp);
    }

    public void updatePlayerLevel(Player player) {
        Player temp = playerRepository.findPlayerByIgn(player.getIgn());
        temp.setLevel(player.getLevel());
        playerRepository.save(temp);
    }
}
