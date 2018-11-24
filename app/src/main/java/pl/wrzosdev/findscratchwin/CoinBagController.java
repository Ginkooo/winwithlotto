package pl.wrzosdev.findscratchwin;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.wrzosdev.findscratchwin.models.CoinBag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinBagController {

    public static List<CoinBag> getData(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        CoinBag[] coinBags;
        Gson gson = new Gson();
        coinBags = gson.fromJson(response.body().string(), CoinBag[].class);

        List<CoinBag> coinBagList = new ArrayList<>();
        for (CoinBag coinBag: coinBags) {
            coinBagList.add(coinBag);
        }

        return coinBagList;
    }

    public static CoinBag getItem(String url) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();

        CoinBag coinBag;
        Gson gson = new Gson();
        coinBag = gson.fromJson(response.body().string(), CoinBag.class);

        return coinBag;
    }

    public static CoinBag getCoinBagById(long id) throws IOException {
        return getItem(Config.url + "/api/coin-bags/" + id);
    }

    public static List<CoinBag> getCoinBags() throws IOException {
        return getData(Config.url + "/api/coin-bags/");
    }

}
