package com.example.community.model;

import lombok.Data;

/**
 * @author create by Jaw
 * @2019/11/27 8:13
 */
@Data
public class Question {
    private Integer id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
