package test.apextechies.test.retrofitnetwork;



import java.util.ArrayList;
import java.util.List;

import test.apextechies.test.UserDetails;

public interface ServiceMethods {

    void userLogin(String user_id, String password, String user_type, String School_id, DownlodableCallback<UserDetails> callback);


}
