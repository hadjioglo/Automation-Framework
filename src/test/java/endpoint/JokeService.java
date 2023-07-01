package endpoint;

import models.JokeResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {
    @GET("random_joke")
    Call<JokeResponse> getJoke();
}
