package com.qzq;

import com.qzq.spider.Bite;
import com.qzq.spider.Gate;
import com.qzq.spider.GateHuilv;
import com.qzq.spider.Poloniex;
import com.qzq.transform.Gate2Bite;
import com.qzq.transform.Gate2Poloniex;

import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2017/12/2
 * @time 11:11
 * @desc
 */
public class Run {
    public static void main(String[] args) {
        Map<String, Map<String, Double>> gate = Gate.run();
        Map<String, Map<String, Double>> bite = Bite.run();
        Map<String, Double> poloniex = Poloniex.run();
        Map<String, Double> huilv = GateHuilv.run();
        System.out.println("huilv");
        System.out.println("buy: " + huilv.get("buy") + "   sell:" + huilv.get("sell"));
        System.out.println("gate2bite");
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


    }
}
