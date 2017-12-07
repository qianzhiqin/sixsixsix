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
        Map<String, Map<String, Double>> gate = Gate.run();
        Map<String, Map<String, Double>> bite = Bite.run();
        Map<String, Double> poloniex = Poloniex.run();
        Map<String, Double> huilv = GateHuilv.run();
        System.out.println("huilv");
        System.out.println("buy: " + huilv.get("buy") + "   sell:" + huilv.get("sell"));
        sb.append("huilv: buy:" + huilv.get("buy") + "   sell:" + huilv.get("sell"));
        sb.append("------------gate2bite--------------");
        Gate2Bite gate2Bite = new Gate2Bite();
        gate2Bite.init(gate, bite);
        gate2Bite.gate2bite();
        System.out.println("-------------------------------------------------------");
        System.out.println("bite2gate");
        gate2Bite.bite2gate();
        System.out.println("-------------------------------------------------------");
        System.out.println("gate2poloniex");
        Gate2Poloniex gate2Poloniex = new Gate2Poloniex();
        gate2Poloniex.init(poloniex, gate, huilv);
        gate2Poloniex.gate2poloniex();
        System.out.println("-------------------------------------------------------");
        System.out.println("poloniex2gate");
        gate2Poloniex.poloniex2gate();
        return "";
    }

    public static void main(String[] args) {

    }
}
