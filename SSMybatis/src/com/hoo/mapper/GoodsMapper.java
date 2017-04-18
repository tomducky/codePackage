/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * GoodsMapper.java
 */

package com.hoo.mapper;

import java.util.Map;

import com.hoo.entity.Goods;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 上午10:21:58 
 */
public interface GoodsMapper extends SqlMapper{
    /** 
     *  根据id得到商品 
     * @param id 
     * @return 
     */  
    Goods getGoodsById(int id);  
   /** 
    * 存放商品 
    * @param good 
    * @return 
    */  
    int  saveGoods(Goods good);  
    /** 
     * 删除id删除商品 
     * @param id 
     * @return 
     */  
    int deleteGoodsById(int id);  
    /* 
     * 更新一个商品 
     */  
    int updateGoodsById(Goods good);  
      
    /* 
     * 根据map参数更新对象 
     */  
    int updateGoodsByIdByMap(Map<String,Object> map);  
      
}
