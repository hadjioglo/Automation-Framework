package endpoint;

import models.UserCreateRequest;
import models.UserCreateResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {
    @POST("api/users")
    Call<UserCreateResponse> createUser(@Body UserCreateRequest userCreateRequest);
}
