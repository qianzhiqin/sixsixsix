package com.qzq.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author qianzhiqin
 * @date 2017/12/1
 * @time 20:48
 * @desc
 */
public class Bite {
    private static final String url = "https://bite.ceo/trade/index_json?t=";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
    private static final String[] coins = new String[]{"btc_cny", "bch_cny", "ltc_cny", "eth_cny", "dash_cny", "hsr_cny", "qtum_cny", "doge_cny"};

    public static String spider(String coin) {
        String result = "";
        String random = getRandom();
        try {
            Connection con = Jsoup.connect(url + random).userAgent(userAgent).timeout(30000);
            con.header("Accept", "application/json, text/javascript, */*; q=0.01");
            con.header("Host", "bite.ceo");
            con.header("Referer", "https://bite.ceo/btc.jsp");
            con.cookie("Hm_lvt_8ea3f9ee7328affe1c09a675ba5961a6", getUnixtime());
            con.cookie("Hm_lpvt_8ea3f9ee7328affe1c09a675ba5961a6", getUnixtime());
            con.cookie("JSPSESSID", "68kpd0ekv7cm2usivjf8pcqvk5");
            con.cookie("lang", "cn  ");
            con.data("market", coin);
            Document doc = con.post();
            result = doc.body().text();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, Double> parse(String result) {
        Map<String, Double> res = new HashMap<String, Double>();
        JSONObject jsonObject = null;
        try {
            jsonObject = JSON.parseObject(result);
        } catch (Exception e) {
            return res;
        }
        JSONArray top = (JSONArray) jsonObject.get("top");
//        top.get(0);
        Double buy = Double.parseDouble(String.valueOf(top.get(2)));
        Double sell = Double.parseDouble(String.valueOf(top.get(1)));
        res.put("sell", sell);
        res.put("buy", buy);
        return res;
    }

    public static Map<String, Map<String, Double>> run() {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < coins.length; i++) {
            String coin = coins[i];
            String res = spider(coin);
            Map<String, Double> coinMap = parse(res);
            map.put(coin.split("_")[0].toLowerCase(), coinMap);
        }
        return map;
    }

    public static String getUnixtime() {
        long unixtime = System.currentTimeMillis();
        return unixtime / 1000 + "";
    }

    public static String getRandom() {
        double random = new Random().nextDouble();
        return random + "";
    }

    public static void main(String[] args) {
//        Map map = run();
//        System.out.println(map);
//        for (Object key : map.keySet() ) {
//            Map obj = (Map) map.get(key.toString());
//           String sell = String.valueOf(obj.get("sell"));
//           String buy = String.valueOf(obj.get("buy"));
//            System.out.println(key.toString() +": "+"sell："+sell +"buy： "+buy);
//        }
        Map<String, Map<String, Double>> map = run();
        System.out.println(map);
    }
}
