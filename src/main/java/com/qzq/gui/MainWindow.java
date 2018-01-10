package com.qzq.gui;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.qzq.gui.listen.FrameListener;
import com.qzq.gui.listen.IndexListener;

import javax.swing.*;
import java.awt.*;

/**
 * @author qianzhiqin
 * @date 2018/1/7
 * @time 23:58
 * @desc
 */
public class MainWindow {
    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JLabel label2;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JPanel indexPanel;
    private JTable dataTable;
    private JScrollPane scrollPane;
    private JLabel gbuy1;
    private JLabel gsell1;
    private JLabel ghuilv1;
    private JLabel zb;
    private JLabel buy2;
    private JLabel sell2;
    private JPanel hulvpanel;
    private JTable g2bTable;
    private JLabel ghuilv2;
    private JLabel gbuy2;
    private JLabel gsell2;
    private JTable g2zTable;
    private JLabel ghuilv3;
    private JLabel gbuy3;
    private JLabel gsell3;
    private JLabel zhuilv;
    private JLabel zbuy;
    private JLabel zsell;


    public static JFrame frame;
    public static MainWindow mainWindow;

    public MainWindow() {
    }

    public static void main(String[] args) {
        Init.initConfig();
        mainWindow = new MainWindow();
        frame = new JFrame("call me 666");
        frame.setIconImage(Constants.IMAGE_ICON);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //得到屏幕的尺寸
        frame.setBounds((int) (screenSize.width * 0.1), (int) (screenSize.height * 0.08), (int) (screenSize.width * 0.8),
                (int) (screenSize.height * 0.8));

        Dimension preferSize = new Dimension((int) (screenSize.width * 0.8),
                (int) (screenSize.height * 0.8));
        frame.setPreferredSize(preferSize);
        frame.setContentPane(mainWindow.mainPanel);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        FrameListener.addListeners();
        IndexListener.addListeners();
        Init.initAll();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JTabbedPane getTabbedPane() {
        return tabbedPane;
    }

    public void setTabbedPane(JTabbedPane tabbedPane) {
        this.tabbedPane = tabbedPane;
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public JLabel getLabel3() {
        return label3;
    }

    public void setLabel3(JLabel label3) {
        this.label3 = label3;
    }

    public JLabel getLabel4() {
        return label4;
    }

    public void setLabel4(JLabel label4) {
        this.label4 = label4;
    }

    public JPanel getIndexPanel() {
        return indexPanel;
    }

    public void setIndexPanel(JPanel indexPanel) {
        this.indexPanel = indexPanel;
    }

    public JTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(JTable dataTable) {
        this.dataTable = dataTable;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JLabel getGbuy1() {
        return gbuy1;
    }

    public void setGbuy1(JLabel gbuy1) {
        this.gbuy1 = gbuy1;
    }

    public JLabel getGsell1() {
        return gsell1;
    }

    public void setGsell1(JLabel gsell1) {
        this.gsell1 = gsell1;
    }

    public JLabel getGhuilv1() {
        return ghuilv1;
    }

    public void setGhuilv1(JLabel ghuilv1) {
        this.ghuilv1 = ghuilv1;
    }

    public JLabel getZb() {
        return zb;
    }

    public void setZb(JLabel zb) {
        this.zb = zb;
    }

    public JLabel getBuy2() {
        return buy2;
    }

    public void setBuy2(JLabel buy2) {
        this.buy2 = buy2;
    }

    public JLabel getSell2() {
        return sell2;
    }

    public void setSell2(JLabel sell2) {
        this.sell2 = sell2;
    }

    public JPanel getHulvpanel() {
        return hulvpanel;
    }

    public void setHulvpanel(JPanel hulvpanel) {
        this.hulvpanel = hulvpanel;
    }

    public JTable getG2bTable() {
        return g2bTable;
    }

    public void setG2bTable(JTable g2bTable) {
        this.g2bTable = g2bTable;
    }

    public JLabel getGhuilv2() {
        return ghuilv2;
    }

    public void setGhuilv2(JLabel ghuilv2) {
        this.ghuilv2 = ghuilv2;
    }

    public JLabel getGbuy2() {
        return gbuy2;
    }

    public void setGbuy2(JLabel gbuy2) {
        this.gbuy2 = gbuy2;
    }

    public JLabel getGsell2() {
        return gsell2;
    }

    public void setGsell2(JLabel gsell2) {
        this.gsell2 = gsell2;
    }

    public JTable getG2zTable() {
        return g2zTable;
    }

    public void setG2zTable(JTable g2zTable) {
        this.g2zTable = g2zTable;
    }

    public JLabel getGhuilv3() {
        return ghuilv3;
    }

    public void setGhuilv3(JLabel ghuilv3) {
        this.ghuilv3 = ghuilv3;
    }

    public JLabel getGbuy3() {
        return gbuy3;
    }

    public void setGbuy3(JLabel gbuy3) {
        this.gbuy3 = gbuy3;
    }

    public JLabel getGsell3() {
        return gsell3;
    }

    public void setGsell3(JLabel gsell3) {
        this.gsell3 = gsell3;
    }

    public JLabel getZhuilv() {
        return zhuilv;
    }

    public void setZhuilv(JLabel zhuilv) {
        this.zhuilv = zhuilv;
    }

    public JLabel getZbuy() {
        return zbuy;
    }

    public void setZbuy(JLabel zbuy) {
        this.zbuy = zbuy;
    }

    public JLabel getZsell() {
        return zsell;
    }

    public void setZsell(JLabel zsell) {
        this.zsell = zsell;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane = new JTabbedPane();
        mainPanel.add(tabbedPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        indexPanel = new JPanel();
        indexPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane.addTab("首页", indexPanel);
        label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Consolas", -1, 28, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("by qianzhiqin");
        indexPanel.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        label1 = new JLabel();
        label1.setIcon(new ImageIcon(getClass().getResource("/icon/logo.png")));
        label1.setText("");
        indexPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(2, 7, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane.addTab("g2p", panel1);
        scrollPane = new JScrollPane();
        panel1.add(scrollPane, new GridConstraints(1, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        dataTable = new JTable();
        scrollPane.setViewportView(dataTable);
        hulvpanel = new JPanel();
        hulvpanel.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(hulvpanel, new GridConstraints(0, 0, 1, 7, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ghuilv1 = new JLabel();
        ghuilv1.setText("gate");
        hulvpanel.add(ghuilv1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gbuy1 = new JLabel();
        gbuy1.setText("");
        hulvpanel.add(gbuy1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        hulvpanel.add(spacer1, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 1, false));
        zb = new JLabel();
        zb.setText("");
        hulvpanel.add(zb, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buy2 = new JLabel();
        buy2.setText("");
        hulvpanel.add(buy2, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gsell1 = new JLabel();
        gsell1.setText("");
        hulvpanel.add(gsell1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sell2 = new JLabel();
        sell2.setText("");
        hulvpanel.add(sell2, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane.addTab("g2b", panel2);
        final JScrollPane scrollPane1 = new JScrollPane();
        panel2.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        g2bTable = new JTable();
        scrollPane1.setViewportView(g2bTable);
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel2.add(panel3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ghuilv2 = new JLabel();
        ghuilv2.setText("gate");
        panel3.add(ghuilv2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gbuy2 = new JLabel();
        gbuy2.setText("");
        panel3.add(gbuy2, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        panel3.add(spacer2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 1, false));
        final JLabel label5 = new JLabel();
        label5.setText("");
        panel3.add(label5, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("");
        panel3.add(label6, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gsell2 = new JLabel();
        gsell2.setText("");
        panel3.add(gsell2, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("");
        panel3.add(label7, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new BorderLayout(0, 0));
        tabbedPane.addTab("g2z", panel4);
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new GridLayoutManager(1, 7, new Insets(0, 0, 0, 0), -1, -1));
        panel4.add(panel5, BorderLayout.NORTH);
        ghuilv3 = new JLabel();
        ghuilv3.setText("gate");
        panel5.add(ghuilv3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gbuy3 = new JLabel();
        gbuy3.setText("");
        panel5.add(gbuy3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        panel5.add(spacer3, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 1, false));
        zhuilv = new JLabel();
        zhuilv.setText("");
        panel5.add(zhuilv, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zbuy = new JLabel();
        zbuy.setText("");
        panel5.add(zbuy, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        gsell3 = new JLabel();
        gsell3.setText("");
        panel5.add(gsell3, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        zsell = new JLabel();
        zsell.setText("");
        panel5.add(zsell, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JScrollPane scrollPane2 = new JScrollPane();
        panel4.add(scrollPane2, BorderLayout.CENTER);
        g2zTable = new JTable();
        scrollPane2.setViewportView(g2zTable);
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        return new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return mainPanel;
    }
}
