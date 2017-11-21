package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ModelAndView test(){
        return new ModelAndView("test");
    }

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    public Object data(){
        return new Result(Result.ERR);
    }


    @RequestMapping(value = "/post_data", method = RequestMethod.POST)
    @ResponseBody
    public Object postData(@RequestParam("data")String data){
        return data;
    }
}
