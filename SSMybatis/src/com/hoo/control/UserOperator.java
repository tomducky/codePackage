/** 
 * Copyright (c) 2012,　六动力（福建）网络科技有限公司  All rights reserved。
 * 
 * UserOperator.java
 */

package com.hoo.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.hoo.entity.User;
import com.hoo.service.UserService;
import com.hoo.utils.UrlHelper;


/**  
 *
 * @author Administrator
 * @date 2013-2-18 下午3:27:39 
 */
@Controller
public class UserOperator {
   
    @Autowired
    protected UserService userService;
    //添加用户页面
    @RequestMapping(value="addUser")
    public String toAddUser(){
        return UrlHelper.ADD_USER;
    }
    
    //添加用户
    @RequestMapping(value="AddUser")
    public String AddUsers(@RequestParam String name,@RequestParam String password){
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        userService.register(user);
        return "redirect:/userList";
    }
    
    //修改用户
    @RequestMapping(value="UpdateUser")
    public String updateUserById(@RequestParam String id,@RequestParam String name,@RequestParam String password){
        User user=new User();
        user.setId(Integer.parseInt(id));
        user.setName(name);
        user.setPassword(password);
        userService.updateUser(user);
        return "redirect:/userList";
    }
    
    //删除用户
    @RequestMapping(value="deleteUserById")
    public @ResponseBody String delUser(@RequestParam String id){
        JSONObject J=new JSONObject();
        if(userService.delUsers(Integer.parseInt(id))){
             J.put("boolean", true);
        }else{
             J.put("boolean", false);
        }
        return J.toString();
    }
    
    //查看用户
    @RequestMapping(value="viewUser")
    public String viewUsers(@RequestParam String id,Model model){
        User users=userService.getUserById(Integer.parseInt(id));
        model.addAttribute("users", users);
        return UrlHelper.VIEW_USER;
    }
    
    //得到要修改用户
    @RequestMapping(value="getUpdateUser")
    public String getUpdateUser(@RequestParam String id,Model model){
        User users=userService.getUserById(Integer.parseInt(id));
        model.addAttribute("users", users);
        return UrlHelper.GET_UPDATE_USER;
    }
    
    //退出系统
    @RequestMapping(value="loginOut")
    public String backLogin(HttpSession session){
        session.invalidate();
        return UrlHelper.USER_LOGIN;
    }
}
