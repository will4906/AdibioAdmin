package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.entity.Manager;
import com.willshuhua.adibioadmin.security.ManagerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ManagerController {

    @Autowired
    ManagerService managerService;

    private Logger logger = Logger.getLogger(ManagerController.class);

    @RequestMapping(value = "/manager_info", method = RequestMethod.GET)
    @ResponseBody
    public Object managerInfo(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        Manager manager = managerService.selectManagerByUsername(username);
        manager.setPassword(null);
        return new Result(Result.OK, manager);
    }

}
