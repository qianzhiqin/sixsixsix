package com.qzq.transform;

import com.qzq.gui.util.CommonUtils;

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
        if (bite.size() > 0 && gate.size() > 0) {

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
        }
        return list;
    }


    public List<Map<String, String>> bite2gate() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        if (bite.size() > 0 && gate.size() > 0) {
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
                list.add(map);
            }
        }
        return list;
    }
    public String[][] getTableData() {
        List<String[]> list =new ArrayList<>();
        if (bite.size() > 0 && gate.size() > 0) {

            for (String key : gate.keySet()) {
                Map<String, String> map = new HashMap<String, String>();
                Map<String, Double> gateMap = gate.get(key);
                double buyGate = gateMap.get("buycny");
                double buyGateUsdt = gateMap.get("buy");
                double sellGate = gateMap.get("sellcny");
                double sellGateUsdt = gateMap.get("sell");
                Map<String, Double> biteMap = bite.get(key) == null ? null : bite.get(key);
                if (biteMap != null) {
                    String[] line = new String[7];
                    double sellBite = biteMap.get("sell");
                    double buyBite = biteMap.get("buy");
                    Double res = (initMoney / buyGate) * sellBite - initMoney;
                    Double b2gRes = (initMoney / buyBite) * sellGate - initMoney;
                    map.put("key", key);
                    map.put("res", res + "");
                    map.put("buy", buyGate + "(" + buyGateUsdt + ")");
                    map.put("sell", sellBite + "");
                    line[0] = key;
                    line[1] = String.valueOf(CommonUtils.df.format(res));
                    line[2] = String.valueOf(CommonUtils.df.format(buyGate)+"("+buyGateUsdt+")");
                    line[3] = String.valueOf(CommonUtils.df.format(sellBite));
                    line[4] = String.valueOf(CommonUtils.df.format(b2gRes));
                    line[5] = String.valueOf(CommonUtils.df.format(buyBite));
                    line[6] = String.valueOf(CommonUtils.df.format(sellGate)+"("+sellGateUsdt+")");
                    list.add(line);
                }
            }
        }
        String[][] res = new String[list.size()][7];
        for (int i = 0; i <list.size() ; i++) {
            String[] tmp = list.get(i);
            for (int j = 0; j <tmp.length ; j++) {
                res[i][j] = tmp[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println("gate2bite");
//        gate2bite();
//        System.out.println("bite2gate");
//        bite2gate();
    }
}
