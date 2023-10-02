package org.example.endpoint;

import org.example.models.SingleUserGetResponse;
import org.example.models.UserCreateUpdateRequest;
import org.example.models.UserCreateResponse;
import org.example.models.UserUpdateResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface UserService {
    @POST("api/users")
    Call<UserCreateResponse> createUser(@Body UserCreateUpdateRequest userCreateRequest);

    @DELETE("api/users/{userId}")
    Call<String> deleteUser(@Path("userId") int userId);

    @PUT("api/users/{userId}")
    Call<UserUpdateResponse> updateUser(@Path("userId") int userId, @Body UserCreateUpdateRequest userCreateUpdateRequest);

    @GET("api/users/{userId}")
    Call<SingleUserGetResponse> getSingleUser(@Path("userId") int userId);
}
