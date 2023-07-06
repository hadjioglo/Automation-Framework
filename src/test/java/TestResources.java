import endpoint.ResourseService;
import lombok.SneakyThrows;
import models.ResourseResponse;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class TestResources {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    ResourseService resourseService = retrofit.create(ResourseService.class);

    @Test
    @SneakyThrows(IOException.class)
    public void getResources() {
        Response<ResourseResponse> response = resourseService.getResources().execute();
        Assert.assertNotNull(response.body());
        Assert.assertEquals(1, response.body().getId());
    }
}
