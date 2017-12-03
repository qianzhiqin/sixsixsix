package com.qzq.transform;

import com.qzq.spider.Gate;
import com.qzq.spider.GateHuilv;
import com.qzq.spider.Poloniex;

import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/2
 * @time 9:20
 * @desc
 */
public class Gate2Poloniex {
    private static Map<String, Double> poloniex = null;
    private static Map<String, Map<String, Double>> gate = null;
    private static double initMoney;
    private static final Map<String, Double> huilv;

    static {
        poloniex = Poloniex.run();
        gate = Gate.run();
        huilv = GateHuilv.run();
        initMoney = 10000 / huilv.get("buy");
    }

    public static void gate2poloniex() {
        for (String key : gate.keySet()) {
            Map<String, Double> gateMap = gate.get(key);
            double buyGate = gateMap.get("buy");
            double buyPoloniex = poloniex.get(key) == null ? 0 : poloniex.get(key);
            if (buyPoloniex != 0) {
                Double res = (initMoney / buyGate) * buyPoloniex - initMoney;
                System.out.println(key + ": " + res + "   |  buy: " + buyGate + "   sell: " + buyPoloniex);
            }
        }
    }

    public static void poloniex2gate() {
        for (String key : gate.keySet()) {
            Map<String, Double> gateMap = gate.get(key);
            double sellGate = gateMap.get("sell");
            double buyPoloniex = poloniex.get(key) == null ? 0 : poloniex.get(key);
            if (buyPoloniex != 0) {
                Double res = (initMoney / buyPoloniex) * sellGate - initMoney;
                System.out.println(key + ": " + res + "   |  buy: " + buyPoloniex + "   sell: " + sellGate);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("gat2poloniex");
        gate2poloniex();
        ;
        System.out.println("poloniex2gate");
        poloniex2gate();
        ;
    }
}
