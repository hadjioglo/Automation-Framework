package org.example.models;

import lombok.Data;

@Data
public class UserUpdateResponse {

    private String name;
    private String job;
    private String updatedAt;
}
