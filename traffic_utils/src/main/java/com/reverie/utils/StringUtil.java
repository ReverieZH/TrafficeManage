package com.reverie.utils;

public class StringUtil {

    /**
    * @Description: 获取当前日期最大编号
    * @Date:
    * @Author:
    */
    public static String getMaxNum(String dlnumber){
        String numstr = dlnumber.substring(dlnumber.length() - 3, dlnumber.length());
        return numstr;
    }

    /**
    * @Description: 获取准驾车型字符串
    * @Date:
    * @Author:
    */
    public static String getvehicleTypeStr(String vehicleType){
        switch (vehicleType){
            case "C1": return "小型汽车C1";
            case "C2": return "小型自动挡汽车C2";
            case "C3": return "低速载货汽车C3";
            case "C4": return "三轮汽车C4";
            case "B1": return "中型客车B1";
            case "B2": return "大型货车B2";
            case "A1": return "大型客车A1";
            case "A3": return "城市公交车A3";
            case "D": return "普通三轮摩托车D";
            case "E": return "普通二轮摩托车E";
            case "F": return "轻便摩托车F";
        }
        return "";
    }

    /**
     * @Description: 获取状态字符串
     * @Date:
     * @Author:
     */
    public static String getStatusStr(String status){
        switch (status){
            case "0": return "限制使用";
            case "1": return "正常使用";
            case "2": return "申请中";
        }
        return "";
    }


    /**
    * @Description: 获取窗口办理字符串
    * @Date:
    * @Author:
    */
    public static String getNeedWinodw(String needWinodwStr){
        switch (needWinodwStr){
            case "0": return "不需要窗口办理";
            case "1": return "需要窗口办理";
        }
        return "";
    }
}
