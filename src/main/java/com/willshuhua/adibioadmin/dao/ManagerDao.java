package com.willshuhua.adibioadmin.dao;

import com.willshuhua.adibioadmin.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ManagerDao {

    Manager queryManagerByUsername(@Param("username")String username);
}
