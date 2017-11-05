package com.willshuhua.adibioadmin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

    private String manager_id;
    private int manager_level;
    private String username;
    private String password;
    private Date register_time;
    private String real_name;
    private String id_number;
    private String telphone;
    private String email;
    private String head_image;
}
