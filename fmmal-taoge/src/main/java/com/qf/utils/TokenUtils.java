package com.qf.utils;

import com.qf.beans.Users;
import io.jsonwebtoken.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
@AllArgsConstructor

public  class TokenUtils {
    //生成jwt令牌
    public static String getToken(Users users){
    Map daidai = new HashMap<String,Object>();
    daidai.put("id","诗诗喜羊羊");
    JwtBuilder builder = Jwts.builder();
    String token = builder.setSubject(users.getUsername())       //设置主题 用用户名来设置就可以
            .setIssuedAt(new Date())             //设置token的生成时间
            .setId(users.getUserId() + "")
            .setClaims(daidai)
            .setExpiration(new Date(System.currentTimeMillis() + 24*60*60*1000))//设置token的过期时间
            .signWith(SignatureAlgorithm.HS256, "sumikoandsiann")//设置加密方式与加密密码
            .compact();
            return token;
    }
}
