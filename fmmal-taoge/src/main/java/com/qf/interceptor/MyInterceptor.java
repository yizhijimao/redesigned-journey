package com.qf.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qf.VO.ResultVO;
import com.qf.utils.ResStatus;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Component

public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if("OPTIONS".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getHeader("token");

        if(token == null){
            doResponse(response,new ResultVO<>(ResStatus.NO,"请先登录",null));
            return false;
        }else {
            try{//验证token合法性
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("sumikoandsiann");//解析token的signinglkey时必须使用生成令牌时的加密密码
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;
            }catch (ExpiredJwtException e){
                doResponse(response,new ResultVO<>(ResStatus.NO,"登录过期",null));
                System.out.println("令牌校验处出错");
            }catch (UnsupportedJwtException e){
                doResponse(response,new ResultVO<>(ResStatus.NO,"token不合法，请重新登录",null));
            }catch (Exception e){
                System.out.println("令牌校验处出错");
                doResponse(response,new ResultVO<>(ResStatus.NO,"令牌校验处出错 请登录",null));
            }
        }
        return false;
    }
    private void doResponse(HttpServletResponse response, ResultVO resultVO) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        String s = new ObjectMapper().writeValueAsString(resultVO);
        writer.print(s);
        writer.flush();
        writer.close();
    }
}
