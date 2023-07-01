package models;

import lombok.Data;

@Data
public class UserCreateRequest {
    private String name;
    private String job;
}
