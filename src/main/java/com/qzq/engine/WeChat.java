package com.qzq.engine;

import com.qzq.spider.Bite;
import com.qzq.spider.Gate;
import com.qzq.spider.GateHuilv;
import com.qzq.spider.Poloniex;
import com.qzq.transform.Gate2Bite;
import com.qzq.transform.Gate2Poloniex;
import com.qzq.wechat.UrlData;
import com.qzq.wechat.WeChatMsg;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/7
 * @time 0:27
 * @desc
 */
public class WeChat {
    private final String CORPID = "wx48550600b1a01730";
    private final String CORPSECRET = "sYreGwLC6f4wZusDqynBPMpHYyg8s_-bJUQLdHGeOxUbHhvcMvBbOyZQZMZDwsrD";
    private final String TOUSER = "qianzhiqin";
    private final String MSGTYPE = "text";
    private final int AGENTID = 1000002;
    private final double cny = 100d;
    private final double usdt = 18d;

    public void sendWeChat(String msg) {
        WeChatMsg sw = new WeChatMsg();
        try {
            String token = sw.getToken(CORPID, CORPSECRET);
//            String postdata = sw.createpostdata("@all", "text", 2, "content", "I love forever~~");
            String postdata = sw.createpostdata(TOUSER, MSGTYPE, AGENTID, msg);
            String resp = sw.post("utf-8", WeChatMsg.CONTENT_TYPE, (new UrlData()).getSendMessage_Url(), postdata, token);
            System.out.println("获取到的token======>" + token);
            System.out.println("请求数据======>" + postdata);
            System.out.println("发送微信的响应数据======>" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMsg() {
        StringBuilder sb = new StringBuilder();
        Map<String, Map<String, Double>> gate = null;
        try {
            gate = Gate.run();
        } catch (Exception e) {

        }
        Map<String, Map<String, Double>> bite = null;
        try {
            bite = Bite.run();
        } catch (Exception e) {
        }
        Map<String, Double> poloniex = null;
        try {
            poloniex = Poloniex.run();
        } catch (Exception e) {

        }
        Map<String, Double> huilv = null;
        try {
            huilv = GateHuilv.run();
        } catch (Exception e) {
        }
        sb.append("-----" + getTime() + "-----" + "\n");
        sb.append("huilv: buy:" + huilv.get("buy") + "   sell:" + huilv.get("sell") + "\n");
        sb.append("-------gate2bite---------" + "\n");
        Gate2Bite gate2Bite = new Gate2Bite();
        gate2Bite.init(gate, bite);
        List<Map<String, String>> gate2biteMap = gate2Bite.gate2bite();
        checkMoney(gate2biteMap, sb, false);
        sb.append("-------bite2gate---------" + "\n");
        List<Map<String, String>> bite2gateMap = gate2Bite.bite2gate();
        checkMoney(bite2gateMap, sb, false);
        sb.append("------ gate2poloniex---------" + "\n");
        Gate2Poloniex gate2Poloniex = new Gate2Poloniex();
        gate2Poloniex.init(poloniex, gate, huilv);
        List<Map<String, String>> gate2poloniexMap = gate2Poloniex.gate2poloniex();
        checkMoney(gate2poloniexMap, sb, true);
        sb.append("-------poloniex2gate--------" + "\n");
        List<Map<String, String>> poloniex2gateMap = gate2Poloniex.poloniex2gate();
        checkMoney(poloniex2gateMap, sb, true);

        System.out.println(sb.toString());
        return sb.toString();
    }

    public void checkMoney(List<Map<String, String>> list, StringBuilder sb, boolean isUsdt) {

        for (Map<String, String> map : list) {
            if (map.size() > 0) {
                String res = map.get("res");
                double money = Double.parseDouble(res);
                if (!isUsdt) {
                    if (money > cny) {
                        sb.append((int) money + "|" + map.get("key") + "|" + map.get("buy") + "|" + map.get("sell") + "\n");
//                        System.out.println((int) money + "|" + map.get("key") + "|" + map.get("buy") + "|" + map.get("sell"));
                    }
                } else {
                    if (money > usdt) {
                        sb.append((int) money + "|" + map.get("key") + "|" + map.get("buy") + "|" + map.get("sell") + "\n");
//                        System.out.println((int) money + map.get("key") + "|" + map.get("buy") + "|" + map.get("sell"));
                    }
                }
            }
        }
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    public static void main(String[] args) {
        WeChat weChat = new WeChat();
        String msg =weChat.getMsg();
        weChat.sendWeChat(msg);
    }
}
