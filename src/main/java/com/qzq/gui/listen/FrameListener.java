package com.qzq.gui.listen;

import com.qzq.gui.MainWindow;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author qianzhiqin
 * @date 2018/1/8
 * @time 0:37
 * @desc
 */
public class FrameListener {
    public static void addListeners() {

        MainWindow.mainWindow.frame.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
                MainWindow.mainWindow.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

            public void windowClosed(WindowEvent e) {
                System.exit(1);
            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}
