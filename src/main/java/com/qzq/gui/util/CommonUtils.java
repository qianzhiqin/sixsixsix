package com.qzq.gui.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author qianzhiqin
 * @date 2018/1/9
 * @time 0:19
 * @desc
 */
public class CommonUtils {
    public static DecimalFormat df   = new DecimalFormat("######0.00");

    public static String now(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
