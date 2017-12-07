package com.qzq.transform;

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
    private Map<String, Map<String, Double>> bite = null;
    private Map<String, Map<String, Double>> gate = null;
    private double initMoney = 10000;

    //    static {
//        bite = Bite.run();
//        gate = Gate.run();
//    }
    public void init(Map<String, Map<String, Double>> gateMap, Map<String, Map<String, Double>> biteMap) {
        bite = biteMap;
        gate = gateMap;
    }

    public List<Map<String, String>> gate2bite() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String key : gate.keySet()) {
            Map<String, String> map = new HashMap<String, String>();
            Map<String, Double> gateMap = gate.get(key);
            double buyGate = gateMap.get("buycny");
            double buyGateUsdt = gateMap.get("buy");
            Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
            if (biteMap != null) {
                double sellBite = biteMap.get("sell");
                Double res = (initMoney / buyGate) * sellBite - initMoney;
                map.put("key", key);
                map.put("res", res + "");
                map.put("buy", buyGate + "(" + buyGateUsdt + ")");
                map.put("sell", sellBite + "");
                System.out.println(key + ": " + res + "   |  buy: " + buyGate + "(" + buyGateUsdt + ")   sell: " + sellBite);
            }
            list.add(map);
        }
        return list;
    }


    public void bite2gate() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (String key : gate.keySet()) {
            Map<String, String> map = new HashMap<String, String>();
            Map<String, Double> gateMap = gate.get(key);
            double sellGate = gateMap.get("sellcny");
            double sellGateUsdt = gateMap.get("sell");
            Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
            if (biteMap != null) {
                double buyBite = biteMap.get("buy");
                Double res = (initMoney / buyBite) * sellGate - initMoney;
                map.put("key", key);
                map.put("res", res + "");
                map.put("buy", buyBite + "");
                map.put("sell", sellGate + "(" + sellGateUsdt + ")");
                System.out.println(key + ": " + res + "   |  buy: " + buyBite + "   sell: " + sellGate + "(" + sellGateUsdt + ")");
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println("gate2bite");
//        gate2bite();
//        System.out.println("bite2gate");
//        bite2gate();
    }
}
