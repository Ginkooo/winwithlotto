package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.wrzosdev.findscratchwin.models.ScratchType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ScratchTypeController {

    public static List<ScratchType> getData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        ScratchType[] scratchTypes;
        Gson gson = new Gson();
        scratchTypes = gson.fromJson(response.body().string(), ScratchType[].class);

        List<ScratchType> scratchTypeList = new ArrayList<>();
        for (ScratchType scratchType: scratchTypes) {
            scratchTypeList.add(scratchType);
        }

        return scratchTypeList;
    }

    public static ScratchType getItem(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        ScratchType scratchType;
        Gson gson = new Gson();
        scratchType = gson.fromJson(response.body().string(), ScratchType.class);

        return scratchType;
    }

    public static ScratchType getScratchTypeById(long id) throws IOException {
        return getItem(Config.url + "/api/scratch-types/" + id);
    }

    public static List<ScratchType> getScratchTypes() throws IOException {
        return getData(Config.url + "/api/scratch-types/");
    }
}
