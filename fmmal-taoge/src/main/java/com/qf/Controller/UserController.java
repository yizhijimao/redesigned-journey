package com.qf.Controller;

import com.qf.VO.ResultVO;
import com.qf.beans.Users;
import com.qf.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@RestController
@RequestMapping("/user")
@CrossOrigin
@Api(value = "用户登录接口",tags = "用户管理")
public class UserController {

    @Autowired
    private UserService userServiceimpl;

    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam()
    })
    @GetMapping("/login")
    public ResultVO login(@RequestParam("username") String name, @RequestParam("password") String pwd){

        ResultVO resultVO = userServiceimpl.checkLogin(name, pwd);
        return resultVO;
    }

    @ApiOperation("用户注册")
    @PostMapping("/regist")
    public ResultVO register(@RequestBody Users user){
        ResultVO resultVO = userServiceimpl.userResgit(user.getUsername(), user.getPassword());
        return resultVO;
    }

}
