import endpoint.UserService;
import models.UserCreateRequest;
import models.UserCreateResponse;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class TestCreateUser {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);

    @Test
    public void createUser() throws IOException {
        UserCreateRequest request = new UserCreateRequest();
        request.setName("Steven");
        request.setJob("worker");

        Response<UserCreateResponse> userCreateResponse = userService.createUser(request).execute();

        Assert.assertTrue(userCreateResponse.isSuccessful());
        Assert.assertNotNull(userCreateResponse.body());

        Assert.assertEquals(userCreateResponse.body().getName(), request.getName());
    }
}
