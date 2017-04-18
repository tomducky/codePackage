/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * GoodsMapperTest.java
 */

package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.hoo.entity.Goods;
import com.hoo.mapper.GoodsMapper;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 上午10:44:38 
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("classpath:applicationContext-*.xml")
public class GoodsMapperTest extends AbstractJUnit38SpringContextTests{

    @Autowired
    private GoodsMapper goodsMapper;
    
    @Test  
    public void testInsertGoods(){  
        Goods goods = new Goods();  
        goods.setGoodName("thinkpads笔记本");  
        goods.setPrice(5200);
        goodsMapper.saveGoods(goods);
    }
    
    @Test  
    public void testGetGoodsById() {  
        Goods goods = goodsMapper.getGoodsById(1);  
        System.out.print(goods.getPrice());  
    }
    
    @Test  
    public void testUpdateGoodsById(){  
        Goods goods = new Goods();  
        goods.setGoodsId(2);  
        goods.setPrice(36.20);  
        goodsMapper.updateGoodsById(goods);  
    }
    
    @Test  
    public void testUpdateGoodsById1(){  
        Goods goods = new Goods();  
        goods.setGoodsId(2);  
        goods.setPrice(3250.20);  
        Map<String,Object> map = new HashMap<String,Object>();  
        map.put("price",5521);  
        map.put("id",2);  
        goodsMapper.updateGoodsByIdByMap(map);  
    }  
    
    @Test  
    public void testDeleteGoodsById(){  
        int id = 2;  
        goodsMapper.deleteGoodsById(id);  
    }  
}
