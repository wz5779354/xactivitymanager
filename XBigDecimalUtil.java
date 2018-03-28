package com.example.wangze.jwt;

import android.util.Log;

import java.math.BigDecimal;

/**
 * 本工具类只负责运算,不负责展示
 */
public class XBigDecimalUtil {
    private static boolean  isLog = true;
    private static final String TAG  = "XBigDecimalUtil";
    //默认运算方式, 小数点后保留两位小数,小数点后舍去
    private static final  int bigDecimalUtilCalcType_Default = 0;

    public static BigDecimal add(BigDecimal b1,BigDecimal b2){
        return  add(b1,b2,bigDecimalUtilCalcType_Default);
    }


    public static BigDecimal add(BigDecimal b1,BigDecimal b2, int bigDecimalUtilCalcType){
        checkBigDecimal(b1,b2);
        return b1.add(b2);
    }

    private static boolean checkBigDecimal(BigDecimal ... bigDecimals){
        boolean flag = true;
        for (BigDecimal bTemp : bigDecimals){
            if (bTemp == null){
                bTemp = new BigDecimal("0");
                flag = false;
            }
        }
        return flag;
    }


    private static void log(String msg){
        if (isLog){
            Log.d(TAG,msg);
        }
    }

    //TODO 类型转换

    //+ //(Bigdecima +Bigdecima ,小数点后几位, 舍去/四舍五入)




    //TODO + - x /
    //type round  舍去  小数点后几位


}
