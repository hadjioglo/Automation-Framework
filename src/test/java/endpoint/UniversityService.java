package endpoint;


import models.UniversityResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface UniversityService {

    @GET("search")
    Call<List<UniversityResponse>> getUniversity(@Query("country") String countryName);

    @GET("search")
    Call<List<UniversityResponse>> getAll();
}
