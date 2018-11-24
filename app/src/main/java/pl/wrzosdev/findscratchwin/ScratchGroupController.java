package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pl.wrzosdev.findscratchwin.models.ScratchGroup;

public class ScratchGroupController {

    public static List<ScratchGroup> getData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        ScratchGroup[] scratchGroups;
        Gson gson = new Gson();
        scratchGroups = gson.fromJson(response.body().string(), ScratchGroup[].class);

        ArrayList<ScratchGroup> scratchGroupList = new ArrayList<>();
        for (ScratchGroup scratchGroup: scratchGroups) {
            scratchGroupList.add(scratchGroup);
        }

        return scratchGroupList;
    }

    public static ScratchGroup getItem(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        ScratchGroup scratchGroups;
        Gson gson = new Gson();
        scratchGroups = gson.fromJson(response.body().string(), ScratchGroup.class);

        return scratchGroups;
    }

    public static ScratchGroup getScratchGroupById(long id) {

    }

}
