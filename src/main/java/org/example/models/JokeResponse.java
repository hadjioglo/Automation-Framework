package org.example.models;

import lombok.Data;

@Data
public class JokeResponse {
    private String type;
    private String setup;
    private String punchline;
    private int id;
}
