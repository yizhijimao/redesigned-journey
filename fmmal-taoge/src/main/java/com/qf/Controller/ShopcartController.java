package com.qf.Controller;

import com.qf.VO.ResultVO;
import com.qf.utils.ResStatus;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopcart")
@CrossOrigin
@Api(value = "提供购物车业务相关接口",tags = "购物车管理")

public class ShopcartController {

    @GetMapping("/list")
    public ResultVO ListCarts(//@RequestHeader("token") String token,
                              @RequestParam Integer userId){

        System.out.println(userId+"daidai");



        return new ResultVO<>(ResStatus.OK,"success",null);
    }


}
