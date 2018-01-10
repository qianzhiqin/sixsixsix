package com.qzq.transform;

import com.qzq.gui.util.CommonUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author qianzhiqin
 * @date 2018/1/9
 * @time 23:12
 * @desc
 */
public class Gate2Zb {
    private Map<String, Map<String, Double>> gate = null;
    private double initMoney = 10000L;
    private Map<String, Map<String, Double>> zb;
    private Map<String, Double> ghuilv;
    private Map<String, Double> zhuilv;

    public void init(Map<String, Map<String, Double>> gateMap, Map<String, Map<String, Double>> zbMap, Map<String, Double> ghuilvMap, Map<String, Double> zhuilvMap) {
        gate = gateMap;
        zb = zbMap;
        ghuilv = ghuilvMap;
        zhuilv = zhuilvMap;
    }

    public String[][] getTableData() {

        List<String[]> list = new ArrayList<>();
        if (zb.size() > 0 && gate.size() > 0 && ghuilv.size() > 0 && zhuilv.size() > 0) {
            double zhuilvSell = zhuilv.get("sell");
            double zhuilvBuy = zhuilv.get("buy");
            for (String key : gate.keySet()) {
                Map<String, Double> gateMap = gate.get(key);
                double buyGate = gateMap.get("buy");
                double buyGateCny = gateMap.get("buycny");
                double sellGate = gateMap.get("sell");
                double sellGateCny = gateMap.get("sellcny");
                double sellZb = zb.get(key) == null ? 0 : zb.get(key).get("sell");
                double buyZb = zb.get(key) == null ? 0 : zb.get(key).get("buy");
                if (sellZb != 0) {
                    String[] line = new String[7];
                    Double buyGateRes = (initMoney / buyGateCny) * (sellZb * zhuilvSell) - initMoney;
                    Double buyZbRes = (initMoney / (buyZb * zhuilvBuy)) * sellGateCny - initMoney;
                    line[0] = key;
                    line[1] = String.valueOf(CommonUtils.df.format(buyGateRes));
                    line[2] = String.valueOf(CommonUtils.df.format(buyGate));
                    line[3] = String.valueOf(CommonUtils.df.format(sellZb));
                    line[4] = String.valueOf(CommonUtils.df.format(buyZbRes));
                    line[5] = String.valueOf(CommonUtils.df.format(buyZb));
                    line[6] = String.valueOf(CommonUtils.df.format(sellGate));
                    list.add(line);
                }
            }
        }
        String[][] res = new String[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            String[] tmp = list.get(i);
            for (int j = 0; j < tmp.length; j++) {
                res[i][j] = tmp[j];
            }
        }
        return res;
    }
}
