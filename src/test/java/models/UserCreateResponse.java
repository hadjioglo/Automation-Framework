package models;

import lombok.Data;

@Data
public class UserCreateResponse {

    private String name;
    private String job;
    private Integer id;
    private String createdAt;
}
