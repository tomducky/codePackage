package com.hoo.servlet;


import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 配置启动时载入配置文件
 * 
 * @author zhys(13960826213@139.com)
 * @created 2012-4-3
 */
@SuppressWarnings("serial")
public class LoadConfigBaseServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(LoadConfigBaseServlet.class);

    /**
     * 启动运用程序
     */
    protected void startApplication() {
        try {
            logger.info("Loading config files.");
            ServletContext application=this.getServletContext(); 
            WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(application);
            PropertyBean propertyBean = (PropertyBean) wac.getBean("propertyBean");
            Map<String, String> maps = propertyBean.getResolvedProps();
            String appPath = application.getRealPath("/");
            System.out.println("appPath..."+appPath);
            maps.put(ConfigKeys.APPLICATION_PATH, appPath);
            SystemGlobals.loadProperties(maps); 

            // 把工程路径存入上下文、方便页面调用
            String path = application.getContextPath();
            application.setAttribute("ctxPath", path);
            application.setAttribute("adminPath", path + SystemGlobals.getValue(ConfigKeys.ADMIN_PATH));
            application.setAttribute("jsPath", path + SystemGlobals.getValue(ConfigKeys.JS_PATH));
            application.setAttribute("cssPath", path + SystemGlobals.getValue(ConfigKeys.CSS_PATH));
            application.setAttribute("imagePath", path + SystemGlobals.getValue(ConfigKeys.IMAGE_PATH));

        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error("Loading config files failed.", e);
        }
    }
}
