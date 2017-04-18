package com.hoo.servlet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

 
 
/** 
 * <p>采用Spring的加载属性信息 在应用中获取<p/> 
 * @author zhys(13960826213@139.com)
 * @created 2012-4-13
 */
public class PropertyBean extends PropertyPlaceholderConfigurer {

    private Map<String, String> resolvedProps;// 将属性保存起来
 
    @SuppressWarnings("deprecation")
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);
        resolvedProps = new HashMap<String, String>();
        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String keyVal = props.getProperty(keyStr); 
            keyVal = parseStringValue(props.getProperty(keyStr), props, new HashSet()); 
            resolvedProps.put(keyStr, keyVal);
        }
    }

    public Map<String, String> getResolvedProps() {
        return resolvedProps;
    }

    public void setResolvedProps(Map<String, String> resolvedProps) {
        this.resolvedProps = resolvedProps;
    }
}