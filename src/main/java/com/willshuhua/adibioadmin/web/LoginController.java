package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/successlogin", method = RequestMethod.GET)
    @ResponseBody
    public Object successLogin(){
        return new Result(Result.OK, "Login Successfully!");
    }

    @RequestMapping(value = "/failurelogin", method = RequestMethod.GET)
    @ResponseBody
    public Object failureLogin(){
        return new Result(Result.ERR, "账号或密码错误");
    }

    @RequestMapping(value = "/successlogout", method = RequestMethod.GET)
    @ResponseBody
    public Object successLogout(){
        return new Result(Result.OK, "Logout Successfully!");
    }
}
