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
public class GateHuilv {
    private static final String url = "https://gate.io/json_svr/query_push/?u=13&c=66661&type=push_main_rates&symbol=USDT_CNY";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.89 Safari/537.36";
//    private static Map<String, Double> map;

    public static String spider() {
        String result = "";
        try {
            Document doc = Jsoup.connect(url).ignoreContentType(true).userAgent(userAgent).timeout(30000).followRedirects(true).get();
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
        JSONObject obj = (JSONObject) jsonObject.get("appraised_rates");
        Double sell = Double.parseDouble(String.valueOf(obj.get("sell_rate")));
        Double buy = Double.parseDouble(String.valueOf(obj.get("buy_rate")));
        res.put("sell", sell);
        res.put("buy", buy);
        return res;
    }

    public static Map<String, Double> run() {
        return parse(spider());
    }

    public static void main(String[] args) {
        run();
    }
}
