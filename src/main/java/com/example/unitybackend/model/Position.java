package com.example.unitybackend.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Document
public class Position implements Serializable {
    private int x;
    private int y;
    private int z;
}