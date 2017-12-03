package com.qzq.spider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/1
 * @time 20:48
 * @desc
 */
public class Gate {
    private static final String url = "https://gate.io/json_svr/query/?u=11&c=124645&type=ask_bid_list_table&symbol=";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
    private static final String[] coins = new String[]{"btc_usdt", "dash_usdt", "ltc_usdt", "xmr_usdt", "xrp_usdt", "eth_usdt", "etc_usdt", "zec_usdt", "bch_usdt", "doge_usdt", "hsr_usdt", "qtum_usdt"};
    private static final Map<String, Double> huilv = GateHuilv.run();

    public static String spider(String coin) {
        String result = "";
        try {
            Document doc = Jsoup.connect(url + coin).ignoreContentType(true).userAgent(userAgent).timeout(30000).followRedirects(true).get();
            result = doc.body().text();
        } catch (IOException e) {
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
        Double sell = Double.parseDouble(String.valueOf(jsonObject.get("bid_rate0")));
        Double buy = Double.parseDouble(String.valueOf(jsonObject.get("ask_rate0")));
        res.put("sell", sell);
        res.put("buy", buy);
        res.put("sellcny", sell * huilv.get("sell"));
        res.put("buycny", buy * huilv.get("buy"));
        return res;
    }

    public static Map<String, Map<String, Double>> run() {
        Map<String, Map<String, Double>> map = new HashMap<String, Map<String, Double>>();
        for (int i = 0; i < coins.length; i++) {
            String coin = coins[i];
            String res = spider(coin);
//            System.out.println(coin + ":  " + res);
            Map<String, Double> coinMap = parse(res);
            map.put(coin.split("_")[0].toLowerCase(), coinMap);
        }
        return map;
    }

    public static void main(String[] args) {
        Map map = run();
//        System.out.println(map);
        for (Object key : map.keySet()) {
            Map obj = (Map) map.get(key.toString());
            if (key.toString().contains("ltc") || key.toString().contains("hsr") || key.toString().contains("qtum") || key.toString().contains("dash") || key.toString().contains("eth")) {

                String sellcny = String.valueOf(obj.get("sellcny"));
                String buycny = String.valueOf(obj.get("buycny"));
                System.out.println(key.toString() + ": " + "sell：" + sellcny + "  buy： " + buycny);
            }
        }
    }
}
