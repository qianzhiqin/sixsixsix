package com.qzq.gui;

import com.alee.laf.WebLookAndFeel;
import com.qzq.engine.DataCenter;
import com.qzq.transform.Gate2Poloniex;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Enumeration;

/**
 * @author qianzhiqin
 * @date 2018/1/8
 * @time 22:05
 * @desc
 */
public class Init {

    public static void initAll() {
        DataCenter.schedule();
        initGlobalFont();
        initTheme();
        initTab();
    }

    /**
     * 设置全局字体
     */
    public static void initGlobalFont() {

        String lowDpiKey = "lowDpiInit";
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
//        if (screenSize.width <= 1366 && StringUtils.isEmpty(configer.getProps(lowDpiKey))) {
//            configer.setFontSize(15);
//            configer.setProps(lowDpiKey, "true");
//            configer.save();
//        }

        Font fnt = new Font("Microsoft YaHei UI", Font.PLAIN, 40);
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }

    /**
     * 初始化look and feel
     */
    public static void initTheme() {
        String theme = "BeautyEye";
        try {
            switch (theme) {
                case "BeautyEye":
                    BeautyEyeLNFHelper.launchBeautyEyeLNF();
                    UIManager.put("RootPane.setupButtonVisible", false);
                    break;
                case "weblaf":
                    UIManager.setLookAndFeel(new WebLookAndFeel());
                    break;
                case "系统默认":
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                case "Windows":
                    UIManager.setLookAndFeel(WindowsLookAndFeel.class.getName());
                    break;
                case "Nimbus":
                    UIManager.setLookAndFeel(NimbusLookAndFeel.class.getName());
                    break;
                case "Metal":
                    UIManager.setLookAndFeel(MetalLookAndFeel.class.getName());
                    break;
                case "Motif":
                    UIManager.setLookAndFeel(MotifLookAndFeel.class.getName());
                    break;
                case "Darcula(推荐)":
                default:
                    UIManager.setLookAndFeel("com.bulenkov.darcula.DarculaLaf");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initTab() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JTable dataTable = MainWindow.mainWindow.getDataTable();
        String[] headerNames = {"coin", "g-p差值", "buy", "sell", "p-g差值", "buy", "sell"};
        String[][] cellData = null;
        System.out.println("=======");
        if (DataCenter.gateHuilvMap != null && DataCenter.poloniexMap != null && DataCenter.gateMap != null) {
            System.out.println("enter");
            Gate2Poloniex gate2Poloniex = new Gate2Poloniex();
            gate2Poloniex.init(DataCenter.poloniexMap, DataCenter.gateMap, DataCenter.gateHuilvMap);
            cellData = gate2Poloniex.getTableData();
        }
        DefaultTableModel model = new DefaultTableModel(cellData, headerNames);
        dataTable.setModel(model);

    }
}
