package com.qzq.transform;

import com.qzq.spider.Bite;
import com.qzq.spider.Gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/2
 * @time 9:20
 * @desc
 */
public class Gate2Bite {
    private static Map<String, Map<String, Double>> bite = null;
    private static Map<String, Map<String, Double>> gate = null;
    private static double initMoney = 10000;

    static {
        bite = Bite.run();
        gate = Gate.run();
    }

    public static void gate2bite() {
        for (String key : gate.keySet()) {
            Map<String, Double> gateMap = gate.get(key);
            double buyGate = gateMap.get("buycny");
            double buyGateUsdt = gateMap.get("buy");
            Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
            if (biteMap != null) {
                double sellBite = biteMap.get("sell");
                Double res = (initMoney / buyGate) * sellBite - initMoney;
                System.out.println(key + ": " + res + "   |  buy: " + buyGate + "(" + buyGateUsdt + ")   sell: " + sellBite);
            }
        }
    }

    public static List<Map<String, String>> gate2bite1() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String key : gate.keySet()) {
            Map<String, String> map = new HashMap<String, String>();
            Map<String, Double> gateMap = gate.get(key);
            double buyGate = gateMap.get("buycny");
            double buyGateUsdt = gateMap.get("buy");
            Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
            map.put("key", key);
            map.put("buy", buyGate + "");
            if (biteMap != null) {
                double sellBite = biteMap.get("sell");
                Double res = (initMoney / buyGate) * sellBite - initMoney;
                System.out.println(key + ": " + res + "   |  buy: " + buyGate + "(" + buyGateUsdt + ")   sell: " + sellBite);
            }
        }
        return list;
    }

    public static void bite2gate() {
        for (String key : gate.keySet()) {
            Map<String, Double> gateMap = gate.get(key);
            double sellGate = gateMap.get("sellcny");
            double sellGateUsdt = gateMap.get("sell");
            Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
            if (biteMap != null) {
                double buyBite = biteMap.get("buy");
                Double res = (initMoney / buyBite) * sellGate - initMoney;
                System.out.println(key + ": " + res + "   |  buy: " + buyBite + "   sell: " + sellGate + "(" + sellGateUsdt + ")");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("gate2bite");
        gate2bite();
        ;
        System.out.println("bite2gate");
        bite2gate();
        ;
    }
}
