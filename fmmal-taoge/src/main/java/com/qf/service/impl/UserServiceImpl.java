package com.qf.service.impl;



import com.qf.VO.ResultVO;
import com.qf.beans.Users;
import com.qf.dao.UsersMapper;
import com.qf.service.UserService;
import com.qf.utils.Base64Utils;
import com.qf.utils.MD5Utils;
import com.qf.utils.ResStatus;
import com.qf.utils.TokenUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

@Service
//@Scope("single")spring默认是单列模式所有可以不加
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    //登录
    public ResultVO checkLogin(String name, String pwd) {


        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",name);
        Users users = usersMapper.selectOneByExample(example);
        // User user = userDao.queryUserByName(name);
        if(users == null){
            return new ResultVO<>(ResStatus.NO,"用户名不正确",null);
        }else {
            String s = MD5Utils.md5(pwd);
            if(s.equals(users.getPassword())){
                String token = TokenUtils.getToken(users);
                System.out.println(token+"在服务成的token打印");

                //下面的是基于beas64的token实现
                //String token = Base64Utils.encode(name + 123456);
                return new ResultVO<>(ResStatus.OK,token,users);
            }else {
                return new ResultVO<>(ResStatus.NO,"密码错误",null);
            }
        }
    }


    @Override
    @Transactional
   // 注册
    public ResultVO userResgit(String name, String pwd) {
        synchronized (this) {
            //1根据用户名来查询当前的用户名有没有被占用
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username",name);
            Users users = usersMapper.selectOneByExample(example);
            //User user = userDao.queryUserByName(name);
            //2如果没有被占用进行注册并保存操作
            if (users == null) {
                //密码需要加密保存
                String s = MD5Utils.md5(pwd);
                Users user1 = new Users();
                user1.setUsername(name);
                user1.setPassword(s);
                user1.setUserRegtime(new Date());
                user1.setUserModtime(new Date());
                int insert = usersMapper.insertUseGeneratedKeys(user1);
                if (insert > 0) {
                    return new ResultVO(ResStatus.OK, "注册成功", user1);
                } else {
                    return new ResultVO<>(ResStatus.NO, "用户名已被占用", null);
                }
            } else {
                return new ResultVO<>(ResStatus.NO, "用户名已被占用", null);
            }
        }
    }
}



