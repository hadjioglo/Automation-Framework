package models;

import lombok.Data;

@Data
public class UserCreateUpdateRequest {
    private String name;
    private String job;
}
