package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.*;
import pl.wrzosdev.findscratchwin.models.AuthToken;

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
                .url(Config.url + "/api/sign_up/")
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
                .url(Config.url + "/api/get_token/")
                .post(requestBody)
                .build();

        Response response = client.newCall(request).execute();

        Gson gson = new Gson();
        AuthToken authToken = gson.fromJson(response.body().string(), AuthToken.class);

        return authToken;
    }


}
