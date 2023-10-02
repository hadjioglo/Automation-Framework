package org.example.university;


import org.example.endpoint.UniversityService;
import lombok.SneakyThrows;
import org.example.models.UniversityResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class RomaniaUniversity extends University {

    private final UniversityService universityService = retrofit.create(UniversityService.class);

    @SneakyThrows(IOException.class)
    public Response<List<UniversityResponse>> getUniversityByCountryRomania() {
        return universityService.getUniversity("romania").execute();
    }

}
