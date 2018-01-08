package com.qzq.gui.listen;

import com.qzq.gui.MainWindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author qianzhiqin
 * @date 2018/1/8
 * @time 0:11
 * @desc
 */
public class IndexListener {
    public static void addListeners() {

        MainWindow.mainWindow.getLabel1().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseEntered(e);
                System.out.println("1111");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

            }
        });
    }
}
