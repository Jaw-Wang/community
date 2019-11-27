package com.example.community.Dto;

import lombok.Data;

/**
 * @author create by Jaw
 * @2019/11/25 8:20
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
