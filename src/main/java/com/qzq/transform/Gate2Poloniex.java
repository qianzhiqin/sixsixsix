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
public class Gate2Poloniex {
    private Map<String, Double> poloniex = null;
    private Map<String, Map<String, Double>> gate = null;
    private double initMoney;
    private Map<String, Double> huilv;

    //     {
//        poloniex = Poloniex.run();
//        gate = Gate.run();
//        huilv = GateHuilv.run();
//        initMoney = 10000 / huilv.get("buy");
//    }
    public void init(Map<String, Double> poloniexMap, Map<String, Map<String, Double>> gateMap, Map<String, Double> huilvMap) {

        poloniex = poloniexMap;
        gate = gateMap;
        huilv = huilvMap;
        initMoney = 10000 / huilv.get("buy");
    }


    public List<Map<String, String>> gate2poloniex() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (poloniex.size() > 0 && gate.size() > 0) {
            for (String key : gate.keySet()) {
                Map<String, String> map = new HashMap<String, String>();
                Map<String, Double> gateMap = gate.get(key);
                double buyGate = gateMap.get("buy");
                double buyPoloniex = poloniex.get(key) == null ? 0 : poloniex.get(key);
                if (buyPoloniex != 0) {
                    Double res = (initMoney / buyGate) * buyPoloniex - initMoney;
                    map.put("key", key);
                    map.put("res", res + "");
                    map.put("buy", buyGate + "");
                    map.put("sell", buyPoloniex + "");
                    System.out.println(key + ": " + res + "   |  buy: " + buyGate + "   sell: " + buyPoloniex);
                }
                list.add(map);
            }
        }
        return list;
    }

    public List<Map<String, String>> poloniex2gate() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (poloniex.size() > 0 && gate.size() > 0) {
            for (String key : gate.keySet()) {
                Map<String, String> map = new HashMap<String, String>();
                Map<String, Double> gateMap = gate.get(key);
                double sellGate = gateMap.get("sell");
                double buyPoloniex = poloniex.get(key) == null ? 0 : poloniex.get(key);
                if (buyPoloniex != 0) {
                    Double res = (initMoney / buyPoloniex) * sellGate - initMoney;
                    map.put("key", key);
                    map.put("res", res + "");
                    map.put("buy", buyPoloniex + "");
                    map.put("sell", sellGate + "");
                    System.out.println(key + ": " + res + "   |  buy: " + buyPoloniex + "   sell: " + sellGate);
                }
                list.add(map);
            }
        }
        return list;
    }

    public void main(String[] args) {
        System.out.println("gat2poloniex");
        gate2poloniex();
        System.out.println("poloniex2gate");
        poloniex2gate();
        ;
    }
}
