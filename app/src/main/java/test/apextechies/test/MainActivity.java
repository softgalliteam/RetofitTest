package test.apextechies.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import test.apextechies.test.retrofitnetwork.DownlodableCallback;
import test.apextechies.test.retrofitnetwork.RetrofitDataProvider;

public class MainActivity extends AppCompatActivity {

    private RetrofitDataProvider retrofitDataProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofitDataProvider = new RetrofitDataProvider(this);
        retrofitDataProvider.userLogin("1056", "123456", "Teacher", "1234", new DownlodableCallback<UserDetails>() {
            @Override
            public void onSuccess(UserDetails result) {
                Log.e("Response :", result.message);
            }

            @Override
            public void onFailure(String error) {

            }

            @Override
            public void onUnauthorized(int errorNumber) {

            }
        });
    }
}
