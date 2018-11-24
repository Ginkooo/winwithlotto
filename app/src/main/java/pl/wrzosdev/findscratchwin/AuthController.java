package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;

public class AuthController {

    public static Response signUp(String username, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", username)
                .addFormDataPart("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://10.250.193.25:8000/api/sing_up/")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        return response;
    }

    public static AuthToken signIn(String username, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", username)
                .addFormDataPart("password", password)
                .build();

        Request request = new Request.Builder()
                .url("http://10.250.193.25:8000/api/get_token/")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        Gson gson = new Gson();
        AuthToken authToken = gson.fromJson(response.body().string(), AuthToken.class);

        return authToken;
    }


}
