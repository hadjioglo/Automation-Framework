package org.example.endpoint;

import lombok.SneakyThrows;
import org.example.models.SingleUserGetResponse;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class UserRestService {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private final UserService userService = retrofit.create(UserService.class);

    @SneakyThrows(IOException.class)
    public Response<SingleUserGetResponse> getSingleUser(int userId) {
        return userService.getSingleUser(userId).execute();
    }
}
