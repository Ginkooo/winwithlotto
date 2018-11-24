package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.wrzosdev.findscratchwin.models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController {

    public static List<User> getAllUsers() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://10.250.193.25:8000/api/users/")
                .build();
        Response response = client.newCall(request).execute();
        Gson gson = new Gson();
        User[] users = gson.fromJson(response.body().string(), User[].class);

        List<User> userList = new ArrayList<>();
        for (User user : users) {
            userList.add(user);
        }

        return userList;
    }

}
