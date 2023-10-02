package org.example.university;


import org.example.endpoint.UniversityService;
import lombok.SneakyThrows;
import org.example.models.UniversityResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class TurkeyUniversity extends University {

    private final UniversityService universityService = retrofit.create(UniversityService.class);

    @SneakyThrows(IOException.class)
    public Response<List<UniversityResponse>> getUniversityByCountryTurkey() {
        return universityService.getUniversity("turkey").execute();
    }

}
