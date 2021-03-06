package com.qzq.engine;

import com.qzq.spider.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author qianzhiqin
 * @date 2018/1/8
 * @time 22:17
 * @desc
 */
public class DataCenter {
    public static ScheduledExecutorService service = Executors.newScheduledThreadPool(8);

    public static Map<String, Map<String, Double>> gateMap = null;
    public static Map<String, Double> poloniexMap = null;
    public static Map<String, Map<String, Double>> biteMap = null;
    public static Map<String, Double>  gateHuilvMap = null;
    public static Map<String, Map<String, Double>> zbMap = null;
    public static Map<String, Double>  zbHuilvMap = new HashMap<>();

    public static void schedule() {
        zbHuilvMap.put("sell",6.63);
        zbHuilvMap.put("buy",6.7);
        TimerTask gate = new TimerTask() {
            @Override
            public void run() {
                Map<String, Map<String, Double>> gateMapTmp = Gate.run();
                System.out.println("1");
                if (gateMapTmp != null) {
                    System.out.println(gateMapTmp.toString());
                    gateMap = gateMapTmp;
                }
            }
        };
        TimerTask poloniex = new TimerTask() {
            @Override
            public void run() {
                Map<String, Double> poloniexMapTmp = Poloniex.run();
                System.out.println("2");
                if (poloniexMapTmp != null) {
                    System.out.println(poloniexMapTmp.toString());
                    poloniexMap = poloniexMapTmp;
                }
            }
        };
        TimerTask bite = new TimerTask() {
            @Override
            public void run() {
                Map<String, Map<String, Double>> biteMapTmp = Bite.run();
                System.out.println("3");
                if (biteMapTmp != null) {
                    System.out.println(biteMapTmp.toString());
                    biteMap = biteMapTmp;
                }
            }
        };
        TimerTask gateHuilv = new TimerTask() {
            @Override
            public void run() {
                Map<String, Double> gateHuilvMapTmp = GateHuilv.run();
                System.out.println("4");
                if (gateHuilvMapTmp != null) {
                    System.out.println(gateHuilvMapTmp.toString());
                    gateHuilvMap = gateHuilvMapTmp;
                }
            }
        };
        TimerTask zb = new TimerTask() {
            @Override
            public void run() {
                Map<String, Map<String, Double>> zbMapTmp = Zb.run();
                System.out.println("5");
                if (zbMapTmp != null) {
                    System.out.println(zbMapTmp.toString());
                    zbMap = zbMapTmp;
                }
            }
        };

        service.scheduleAtFixedRate(gate, 0, 1, TimeUnit.MINUTES);
        service.scheduleAtFixedRate(poloniex, 0, 1, TimeUnit.MINUTES);
        service.scheduleAtFixedRate(bite, 0, 1, TimeUnit.MINUTES);
        service.scheduleAtFixedRate(gateHuilv, 0, 1, TimeUnit.MINUTES);
        service.scheduleAtFixedRate(zb, 0, 1, TimeUnit.MINUTES);

    }
}
