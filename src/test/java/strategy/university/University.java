package strategy.university;

import endpoint.UniversityService;
import lombok.SneakyThrows;
import models.UniversityResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

public abstract class University {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://universities.hipolabs.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UniversityService universityService = retrofit.create(UniversityService.class);


    @SneakyThrows(IOException.class)
    public Response<List<UniversityResponse>> getAllUniversitiesIgroningCountryFilter() {
        return universityService.getAll().execute();
    }
}
