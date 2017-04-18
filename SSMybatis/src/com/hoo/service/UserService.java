/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * UserService.java
 */

package com.hoo.service;

import java.util.List;

import com.hoo.entity.User;
import com.hoo.utils.Page;

/**  
 *
 * @author Administrator
 * @date 2013-2-5 上午10:46:05 
 */
public interface UserService {

    /**
     * 获取所有的用户信息
     * @return
     * @Adder by Administrator 2013-2-5 上午10:48:35
     */
    public List<User> queryAllUsers();
    
    /**
     * 用户登录
     * @param user
     * @return 
     * @Adder by Administrator 2013-2-5 上午10:48:48
     */
    public boolean login(User user);
    
    /**
     * 用户登录
     * @param user
     * @return 
     * @Adder by Administrator 2013-2-5 上午10:49:07
     */
    public boolean register(User user);
    
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     * @Adder by Administrator 2013-2-18 上午10:54:49
     */
    public boolean getUserByName(String name);
    
    /**
     * 根据id删除用户
     * @param id
     * @return
     * @Adder by Administrator 2013-2-18 下午4:52:56
     */
    public boolean delUsers(int id);
    
    /**
     * 根据id查找用户
     * @param id
     * @return
     * @Adder by Administrator 2013-2-18 下午5:02:03
     */
    public User getUserById(int id);
    
    /**
     * 修改用户
     * @param user
     * @Adder by Administrator 2013-2-18 下午5:40:32
     */
    public void updateUser(User user);
    
    /**
     * 查询所有的用户信息，用分页显示
     * @return
     * @Adder by Administrator 2013-2-19 上午11:49:22
     */
    public Page queryAllUser(Page page);
}
