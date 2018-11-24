package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.wrzosdev.findscratchwin.models.Scratch;

import java.io.IOException;
import java.util.ArrayList;

public class ScratchController {

    public static ArrayList<Scratch> getData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
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

    public static ArrayList<Scratch> getAllScratches() throws IOException {
        return getData(Config.url + "/api/scratches/");
    }

    public static ArrayList<Scratch> getAddScratchesBetweenLatitude(double latitudeLte, double latitudeGte) throws IOException {
        return getData(Config.url + "/api/scratches/?latitude__lte="
                + latitudeLte + "&latitude__gte=" + latitudeGte + "&longtitude__lte=&longtitude__gte=");
    }

    public static ArrayList<Scratch> getAddScratchesBetweenLongtitude(double longtitudeLte, double longtitudeGte) throws IOException {
        return getData(Config.url + "/api/scratches/?latitude__lte=&latitude__gte=&longtitude__lte="
                + longtitudeLte + "&longtitude__gte=" + longtitudeGte);
    }

    public static ArrayList<Scratch> getAddScratchesBetweenLatitudeAndLongtitude(double latitudeLte,
                                                                                 double latitudeGte,
                                                                                 double longtitudeLte,
                                                                                 double longtitudeGte) throws IOException {
        return getData(Config.url + "/api/scratches/?latitude__lte="
                + latitudeLte + "&latitude__gte=" + latitudeGte + "&longtitude__lte="
                + longtitudeLte + "&longtitude__gte=" + longtitudeGte);
    }
}
