package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.wrzosdev.findscratchwin.models.Award;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AwardController {

    public static List<Award> getData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        Award[] awards;
        Gson gson = new Gson();
        awards = gson.fromJson(response.body().string(), Award[].class);

        List<Award> awardList = new ArrayList<>();
        for (Award award: awards) {
            awardList.add(award);
        }

        return awardList;
    }

    public static Award getItem(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        Award award;
        Gson gson = new Gson();
        award = gson.fromJson(response.body().string(), Award.class);

        return award;
    }

    public static Award getAwardById(long id) throws IOException {
        return getItem(Config.url + "/api/awards/" + id);
    }

    public static List<Award> getAwards() throws IOException {
        return getData(Config.url + "/api/awards/");
    }

}
