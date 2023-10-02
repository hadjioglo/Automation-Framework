package org.example.models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class UniversityResponse {

    @SerializedName("web_pages")
    private List<String> webPages;
    private List<String> domains;
    private String country;

    @SerializedName("alpha_two_code")
    private String alfaTwoCode;
    private String name;

    @SerializedName("state-province")
    private String stateProvince;
}
