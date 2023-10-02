package org.example.endpoint;

import org.example.models.ResourseResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ResourseService {
    @GET("api/unknown")
    Call<ResourseResponse> getResources();
}
