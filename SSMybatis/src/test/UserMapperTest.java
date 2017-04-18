/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * userMapperTest.java
 */

package test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit38.AbstractJUnit38SpringContextTests;

import com.hoo.entity.User;
import com.hoo.mapper.UserMapper;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 上午10:44:38 
 */
@SuppressWarnings("deprecation")
@ContextConfiguration("classpath:applicationContext-*.xml")
public class UserMapperTest extends AbstractJUnit38SpringContextTests{

    @Autowired
    private UserMapper userMapper;
    
    @Test
    public void testSaveUser(){
       User user=new User();
       user.setName("huanghai");
       user.setPassword("041086");
       userMapper.saveUser(user);
       System.out.println("添加用户成功！");
    }
    
    @Test
    public void testGetUserById(){
        User user=userMapper.getUserById(2);
        System.out.println(user.getName());
    }
    
    @Test
    public void testGetUsers(){
        List<User> users=userMapper.getUsers();
        for(User u: users){
            System.out.println(u.getId()+":"+u.getName()+":"+u.getPassword());
        }
    }
    
    @Test
    public void testUpdateUser(){
        User user=new User();
        user.setId(3);
        user.setName("huanghaibin");
        userMapper.updateUser(user);
        System.out.println("修改用户成功！");
    }
   
    @Test
    public void testDeleteUser(){
        userMapper.deleteUser(2);
        System.out.println("删除成功！");
    }
    
    @Test
    public void testGetUserByName(){
        User user=userMapper.getUserByName("huanghaibin");
        System.out.println(user.getId()+":"+user.getName());
    }
    
    @Test
    public void testGetAllUsers(){
        List<User> users=userMapper.getUsers();
        for(User u : users){
            System.out.println(u.getName()+"\n");
        }
    }
    
}
