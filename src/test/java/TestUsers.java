import endpoint.UserService;
import lombok.SneakyThrows;
import models.UserCreateUpdateRequest;
import models.UserCreateResponse;
import models.UserUpdateResponse;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class TestUsers {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);

    @Test
    public void createUser() throws IOException {
        UserCreateUpdateRequest request = new UserCreateUpdateRequest();
        request.setName("Steven");
        request.setJob("worker");

        Response<UserCreateResponse> userCreateResponse = userService.createUser(request).execute();

        Assert.assertTrue(userCreateResponse.isSuccessful());
        Assert.assertNotNull(userCreateResponse.body());

        Assert.assertEquals(userCreateResponse.body().getName(), request.getName());
    }

    @Test
    @SneakyThrows(IOException.class)
    public void deleteUser() {
        int userId = 2;
        Response<String> response = userService.deleteUser(userId).execute();
        Assert.assertNotNull(response);
        Assert.assertEquals(204, response.code());
    }

    @Test
    @SneakyThrows(IOException.class)
    public void updateUser() {
        UserCreateUpdateRequest request = new UserCreateUpdateRequest();
        String expectedName = "morpheus";
        String expectedJob = "zion resident";
        int userId = 2;

        request.setJob(expectedJob);
        request.setName(expectedName);

        Response<UserUpdateResponse> response = userService.updateUser(userId, request).execute();
        Assert.assertNotNull(response.body());
        Assert.assertEquals(expectedName, response.body().getName());
        Assert.assertEquals(expectedJob, response.body().getJob());
    }
}
