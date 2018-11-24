package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;

public class StaticData {

    public static ArrayList<Scratch> getData() throws IOException {

        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("http://10.250.193.25:8000/api/scratches/")
                    .build();

            Response response = client.newCall(request).execute();

            Scratch[] scratches;
            Gson gson = new Gson();
            scratches = gson.fromJson(response.body().string(), Scratch[].class);

            ArrayList<Scratch> scratchArrayList = new ArrayList<>();
            for (Scratch scratch: scratches) {
                scratchArrayList.add(scratch);
            }

            return scratchArrayList;
    }
}
