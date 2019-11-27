package com.example.community.model;

import lombok.Data;

/**
 * @author create by Jaw
 * @2019/11/25 22:10
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String accountId;
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatarUrl;


}
