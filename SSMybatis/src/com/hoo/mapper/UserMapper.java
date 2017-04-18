/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * UserMappper.java
 */

package com.hoo.mapper;

import java.util.List;

import com.hoo.entity.User;
import com.hoo.utils.Page;

/**  
 *
 * @author Administrator
 * @date 2013-1-31 下午2:15:05 
 */
public interface UserMapper  extends SqlMapper{

    /**
     * 添加用戶
     * @param user
     * @Adder by Administrator 2013-1-31 下午2:16:23
     */
    public void saveUser(User user);
    
    /**
     * 根据id查找用户
     * @param id
     * @return
     * @Adder by Administrator 2013-1-31 下午2:17:23
     */
    public User getUserById(int id);
    
    /**
     * 查询所有的用户
     * @return
     * @Adder by Administrator 2013-1-31 下午2:18:50
     */
    public List<User> getUsers();
    
    public List<User> queryAllUser(Page page);
    
    /**
     * 更新用户
     * @param user
     * @Adder by Administrator 2013-1-31 下午2:19:30
     */
    public void updateUser(User user);
    
    /**
     * 根据id删除用户
     * @param i
     * @Adder by Administrator 2013-1-31 下午2:20:15
     */
    public void deleteUser(int i);
    
    /**
     * 根据用户名查找用户
     * @param name
     * @return
     * @Adder by Administrator 2013-2-1 下午4:53:20
     */
    public User getUserByName(String name);
}
