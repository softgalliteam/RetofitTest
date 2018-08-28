package test.apextechies.test.retrofitnetwork;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.apextechies.test.UserDetails;

public class RetrofitDataProvider extends AppCompatActivity implements ServiceMethods {
    private Context context;

    private ApiRetrofitService createRetrofitService() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apextechies.com/softgalli/index.php/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiRetrofitService.class);

    }

    public  RetrofitDataProvider(Context context)
    {
        this.context = context;
    }



    @Override
    public void userLogin(String user_id, String password, String user_type, String School_id, final DownlodableCallback<UserDetails> callback) {
        createRetrofitService().userLogin(user_id, password, user_type, School_id).enqueue(
                new Callback<UserDetails>() {
                    @Override
                    public void onResponse(@NonNull Call<UserDetails> call, @NonNull final Response<UserDetails> response) {
                        if (response.code()==200) {

                            UserDetails mobileRegisterPojo = response.body();
                            callback.onSuccess(mobileRegisterPojo);

                        } else

                        {
                            if (response.code() == 401)
                            {
                                callback.onUnauthorized(response.code());
                            }
                            else {
                                /*checkStatusCode(context, response.code(), response.message(), new OnCheckStatusCode() {
                                    @Override
                                    public void statuscode(int code) {
                                        callback.onFailure("");
                                    }
                                });*/
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<UserDetails> call, @NonNull Throwable t) {
                        Log.d("Result", "t" + t.getMessage());
                        callback.onFailure(t.getMessage());

                    }
                }
        );
    }
}
