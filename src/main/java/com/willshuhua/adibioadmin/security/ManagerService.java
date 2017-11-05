package com.willshuhua.adibioadmin.security;

import com.willshuhua.adibioadmin.dao.ManagerDao;
import com.willshuhua.adibioadmin.entity.Manager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class ManagerService implements UserDetailsService {

    private Logger logger = Logger.getLogger(ManagerService.class);

    @Autowired
    ManagerDao managerDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Manager manager = managerDao.selectManagerByUsername(username);
        if (manager == null){
            throw new UsernameNotFoundException("Please check the account!");
        }
        logger.info(manager);
        return new User( manager.getUsername(), manager.getPassword(), new ArrayList<>());
    }

    public Manager selectManagerByUsername(String username){
        return managerDao.selectManagerByUsername(username);
    }
}
