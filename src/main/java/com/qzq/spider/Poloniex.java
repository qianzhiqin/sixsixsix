package com.qzq.spider;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/1
 * @time 20:48
 * @desc
 */
public class Poloniex {
    private static final String url = "https://poloniex.com/public?command=returnTicker";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
    private static final String[] coins = new String[]{"USDT_BTC", "USDT_DASH", "USDT_LTC", "USDT_NXT", "USDT_STR", "USDT_XMR", "USDT_XRP", "USDT_ETH", "USDT_ETC", "USDT_REP", "USDT_ZEC", "USDT_BCH"};

    public static String spider() {
        String result = "";
        try {
            Document doc = Jsoup.connect(url).ignoreContentType(true).userAgent(userAgent).timeout(30000).followRedirects(true).get();
            result = doc.body().text();
//            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Double> parse(String result) {
        Map<String, Double> res = new HashMap<String, Double>();
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Map<String, String>>>() {
        }.getType();
        Map<String, Map<String, String>> map = gson.fromJson(result, type);
//        System.out.println(map);
        for (int i = 0; i < coins.length; i++) {
            String coin = coins[i];
            String[] coinSplit = coin.split("_");
//            String coinName = (coinSplit[1] + "_" + coinSplit[0]).toLowerCase();
            String coinName = coinSplit[1].toLowerCase();
            Map<String, String> coinMap = map.get(coin);
            double price = Double.parseDouble(coinMap.get("last"));
            res.put(coinName, price);
        }
        return res;
    }

    public static Map<String, Double> run() {
        return parse(spider());
    }

    public static void main(String[] args) {
        Map map = run();
//        System.out.println(map);
    }
}
