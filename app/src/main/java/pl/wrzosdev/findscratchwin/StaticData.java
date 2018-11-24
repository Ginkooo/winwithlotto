package pl.wrzosdev.findscratchwin;

import android.graphics.Point;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class StaticData {

    public static Point getData() throws IOException {

        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://10.250.193.25:8000/api/scratches/")
                    .build();

            Response response = client.newCall(request).execute();

            //Point p = new Point()
        System.out.println(response.body().string());

            return null;

    }
}
