package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/successlogin", method = RequestMethod.GET)
    @ResponseBody
    public Object successLogin(){
        return new Result(Result.OK, "Login Successfully!");
    }
}
