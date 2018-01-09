package com.qzq.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2018/1/9
 * @time 15:37
 * @desc
 */
public class Zb {
    private static final String url = "https://trans.zb.com/line/topall?jsoncallback=jQuery191047227532085855284_1515483558860&_=1515483558862";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
    private static final String[] coins = new String[]{"btc", "bcc", "ubtc", "ltc", "eth", "etc", "bts", "eos", "qtum", "hsr", "xrp", "bcd", "dash", "sbtc", "ink", "tv", "bcx", "bth", "lbtc", "chat", "hlc", "bcw", "btp", "topc", "ent", "bat", "1st", "safe"};

    public static void main(String[] args) {
        Map<String, Map<String, Double>> run = run();
        for (String key:run.keySet()) {
            System.out.println(key +":" +run.get(key).toString());
        }

    }

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

    public static Map<String, Map<String, Double>> parse(String result) {
        result = result.substring(result.indexOf("(") + 1, result.length() - 1);
//        System.out.println(result);
        Map<String, Map<String, Double>> res = new HashMap<>();
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray jsonArray = (JSONArray) jsonObject.get("datas");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject data = (JSONObject) jsonArray.get(i);
            String market = String.valueOf(data.get("market"));
//            System.out.println(market);
            if (market.contains("USDT")) {
                Map<String, Double> map = new HashMap<String, Double>();
                map.put("sell",data.getDouble("sell1Price"));
                map.put("buy",data.getDouble("buy1Price"));
                res.put(data.getString("currrency"),map);
            }
        }

        return res;
    }

    public static Map<String, Map<String, Double>> run() {
        return parse(spider());
    }

}
