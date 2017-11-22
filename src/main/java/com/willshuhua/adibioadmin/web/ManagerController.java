package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.entity.Manager;
import com.willshuhua.adibioadmin.security.ManagerService;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ManagerController {

    @Autowired
    ManagerService managerService;

    private Logger logger = Logger.getLogger(ManagerController.class);

    @RequestMapping(value = "/manager_info", method = RequestMethod.GET)
    public Object managerInfo(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        Manager manager = managerService.selectManagerByUsername(username);
        manager.setPassword(null);
        return new Result(Result.OK, manager);
    }

    @RequestMapping(value = "/check_password", method = RequestMethod.POST)
    public Object checkPassword(@RequestParam("password")String password){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        Manager manager = managerService.selectManagerByUsername(username);
        if (manager.getPassword().equals(password)){
            return new Result(Result.OK, true);
        }else {
            return new Result(Result.OK, false);
        }
    }

    @RequestMapping(value = "/update_password", method = RequestMethod.POST)
    public Object updatePassword(@RequestParam("old_password")String oldPassword, @RequestParam("new_passsord")String newPassword){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        Manager manager = managerService.selectManagerByUsername(username);
        if (manager.getPassword().equals(oldPassword)){
            manager.setPassword(newPassword);
            managerService.updatePassword(manager);
            return new Result(Result.OK);
        }else {
            return new Result(Result.ERR);
        }
    }

}
