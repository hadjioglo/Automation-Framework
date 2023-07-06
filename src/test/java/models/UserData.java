package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class UserData {

    private Integer id;

    private String email;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    private String avatar;
}
