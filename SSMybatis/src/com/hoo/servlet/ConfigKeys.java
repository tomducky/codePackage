package com.hoo.servlet;

public class ConfigKeys {
    private ConfigKeys() {
    }
    
    /**
     * 应用路径loadConfigBaseServlet加载的时候获取并设置
     */
    public static final String APPLICATION_PATH = "application.path";
      
    public static final String AUTHCODE_TIME = "authcode.time";// 验证码有效时间
    public static final String AUTHCODE_DATA = "authcode.data";// 验证码
    public static final String APPLICATION_CHARSET = "application.charset";// 系统编码 
    public static final String CSS_PATH = "css.path";
    public static final String IMAGE_PATH = "image.path";
    public static final String JS_PATH = "js.path";
    public static final String WEB_STYLE = "style";
    public static final String ADMIN_PATH = "admin.path";
    
    /**
     * 注解缓存统一开关
     */
    public static final String ANNOTATION_CACHE_DOOR = "annotation.cache.door";
    public static final String ACL_DOOR = "acl.door";
    public static final String COOKIE_PATH = "cookiePath";
    public static final String APP_TYPE = "app.type";

    /**
     * 异常错误页面
     */
    public static final String ERROR_PAGE = "error.page";

}
