import org.example.endpoint.UserRestService;
import org.example.endpoint.UserService;
import lombok.SneakyThrows;
import org.example.models.UserCreateResponse;
import org.example.models.UserCreateUpdateRequest;
import org.example.models.UserCreateUpdateRequest.UserCreateUpdateRequestBuilder;
import org.example.models.UserUpdateResponse;
import org.junit.Assert;
import org.junit.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUsers {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);

    @Test
    public void createUser() throws IOException {
        UserCreateUpdateRequest request = UserCreateUpdateRequestBuilder.builder().setName("Steven").setJob("worker").build();
//        request.setName("Steven");
//        request.setJob("worker");

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

        Properties properties = new Properties();
        FileInputStream propertiesFile = new FileInputStream("user.properties");
        properties.load(propertiesFile);

        UserCreateUpdateRequest request = new UserCreateUpdateRequest();
        String expectedName = properties.getProperty("userName");
        String expectedJob = "zion resident";
        int userId = Integer.parseInt(properties.getProperty("userId"));

        request.setJob(expectedJob);
        request.setName(expectedName);

        Response<UserUpdateResponse> response = userService.updateUser(userId, request).execute();
        Assert.assertNotNull(response.body());
        Assert.assertEquals(expectedName, response.body().getName());
        Assert.assertEquals(expectedJob, response.body().getJob());
    }

    @Test
    public void getSingleUser() {
        UserRestService userRestService = new UserRestService();
        var response = userRestService.getSingleUser(2);

        Assert.assertTrue(response.isSuccessful());
        Assert.assertNotNull(response.body());
        var actualName = response.body().getData().getFirstName();

        Assert.assertEquals("Janet", actualName);
    }
}
