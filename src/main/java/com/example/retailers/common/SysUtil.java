package com.example.retailers.common;

public class SysUtil {

    /**
     * 非空判断 null 或者 ""  返回 true
     * @param object
     * @return
     */
    public static boolean isNullOrEmpty (Object object){
        String ob = String.valueOf(object);
        return (ob.equals("")||ob.equals("null"));
    }

    /**
     * 转字符串
     * @param o
     * @return
     */
    public static String toStr(Object o){
        return String.valueOf(o);
    }

    /**
     * 转int 非数字 和 null 返回 0
     * @param o
     * @return
     */
    public static int toInt(Object o){
        try{
            return Integer.valueOf(toStr(o));
        }catch (Exception e){
            return 0;
        }
    }

}
