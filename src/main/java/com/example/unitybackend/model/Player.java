package com.example.unitybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Player implements Serializable {
    @Id
    private String id;
    @Indexed(unique = true)
    private String ign;
    private int level;
    private String password;
    private Position position;
}
