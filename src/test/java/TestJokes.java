import org.example.endpoint.JokeService;
import org.example.models.JokeResponse;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class TestJokes {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://official-joke-api.appspot.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    JokeService jokeService = retrofit.create(JokeService.class);

    @Test
    public void testJoke() throws IOException {
        Response<JokeResponse> response = jokeService.getJoke().execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertNotNull(response.body());

        System.out.println(response.body().getSetup());
        System.out.println(response.body().getPunchline());
    }
}
