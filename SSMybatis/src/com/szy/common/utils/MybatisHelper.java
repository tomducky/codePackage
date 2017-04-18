/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * MybatisHelper.java
 */

package com.szy.common.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**  
 *
 * @author Administrator
 * @date 2013-1-30 上午11:13:39 
 */
public class MybatisHelper {
    private static SqlSessionFactory sqlSessionFactory;  
    
    static{  
          
        String resourceLocation = "applicationContext-common.xml";  
  
        Reader reader = null;  
        try {  
            //Resources  mybatis 用来加载各种配置文件，这里我们从类路径加载  
            reader = Resources.getResourceAsReader(resourceLocation);  
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        
    }  
      
    public static SqlSession getSqlSession(){  
        return sqlSessionFactory.openSession();  
    }  
      
}  