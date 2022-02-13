package com.example.unitybackend.controller;

import com.example.unitybackend.model.Player;
import com.example.unitybackend.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class PlayerController {
    private final PlayerService playerService;

    // add player
    @PostMapping("api/v1/player")
    public void addPlayer(@RequestBody Player player){
        System.out.println("addPlayer -> " + player.getIgn());
        playerService.addPlayer(player);
    }

    // get player list
    @GetMapping("api/v1/players")
    @ResponseBody
    public List<Player> fetchAllPlayers(){
        System.out.println("getAllPlayers");
        return playerService.getAllPlayers();
    }

    // get player by ign
    @GetMapping("api/v1/player/{ign}")
    @ResponseBody
    public Player getPlayer(@PathVariable String ign){
        System.out.println("getPlayer -> " + ign);
        return playerService.getPlayer(ign);
    }

    // update player position
    @PutMapping("api/v1/player/position")
    public void updatePlayerPosition(@RequestBody Player player){
        System.out.println("update -> " + player.getIgn() + " " + player.getPosition());
        playerService.updatePlayerPosition(player);
    }

    // update player level
    @PutMapping("api/v1/player/level")
    public void updatePlayerLevel(@RequestBody Player player){
        System.out.println("update -> " + player.getIgn() + " level " + player.getLevel());
        playerService.updatePlayerLevel(player);
    }
}
