package test.apextechies.test;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class UserDetails {

    @SerializedName(("status"))
    String status;
    @SerializedName(("message"))
    String message;
    @SerializedName(("data"))
    ArrayList<UserDataDetails> data;


}
 class UserDataDetails {

     @SerializedName(("id"))
     String id;
     @SerializedName(("user_id"))
     String user_id;
     @SerializedName(("name"))
     String name;
}