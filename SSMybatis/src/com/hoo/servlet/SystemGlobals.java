package com.hoo.servlet;

import java.util.HashMap;
import java.util.Map;


/**
 * 存储配置文件中的变量 如果变量值传入${....}标示在配置文件中读取改变量的值如：configPath=${web.dir}/webapp
 * ，${web.dir}就是读取在configPath之前定义的web.dir的变量值
 * 
 * @author zhys(13960826213@139.com)
 * @created 2012-4-3
 */
public class SystemGlobals extends SpringContextHolder{
    
    private static HashMap<String, String> properties;

    // 系统开关描述 on:1 off:0
    public static final int COMMON_DOOR_INT_ON = 1;
    public static final int COMMON_DOOR_INT_OFF = 0;
    
    public static final String COMMON_DOOR_STR_ON = "1";
    public static final String COMMON_DOOR_STR_OFF = "0";
    
    public static final String COMMON_STR_FALSE = "false";
    public static final String COMMON_STR_TRUE = "true";
    
    public static final boolean COMMON_BOL_FALSE = false;
    public static final boolean COMMON_BOL_TRUE = true;

    /**
     *  私有构造函数
     */
    private SystemGlobals() {
    }

    /**
     * 载入资源文件 （该方法只在初使化的时候使用）
     * 
     * @param maps
     */ 
    public static void loadProperties(Map<String, String> maps) {
        properties = (HashMap<String, String>) maps;
    }

    /**
     * 获取资源文件的值
     * 
     * @param field
     * @return
     */
    public static String getValue(String field) {
        String returnValue = properties.get(field);
        if (returnValue == null || "".equals(returnValue))
            returnValue = "";
        return returnValue.trim();
    }

    /**
     * 转换变量为数值类型
     * @param field
     * @return
     */
    public static int getIntValue(String field) {
        return Integer.parseInt(getValue(field));
    }

    /**
     * 资源属性为true返回true
     * @param field
     * @return
     */
    public static boolean getBoolValue(String field) {
        return SystemGlobals.COMMON_STR_TRUE.equals(getValue(field));
    }

    /**
     * 开关为开状态返回true
     * @param field
     * @return
     */
    public static boolean getOnValue(String field) {
        return SystemGlobals.COMMON_DOOR_STR_ON.equals(getValue(field));
    }
    
    /**
     * 开关为关状态返回true
     * @param field
     * @return
     */
    public static boolean getOffValue(String field) {
        return SystemGlobals.COMMON_DOOR_STR_OFF.equals(getValue(field));
    }
}
