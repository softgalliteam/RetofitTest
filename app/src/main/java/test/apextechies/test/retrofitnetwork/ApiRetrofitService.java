package test.apextechies.test.retrofitnetwork;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.apextechies.test.UserDetails;

public interface ApiRetrofitService {


    @Headers("x-api-key:1a!2b@3c#4d$5e%6f^")
    @POST("user_login")
    @FormUrlEncoded
    Call<UserDetails> userLogin(@Field("user_id") String user_id, @Field("password") String password, @Field("user_type") String user_type, @Field("school_id") String school_id);


}
