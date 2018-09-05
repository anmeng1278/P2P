package com.am.p2p.exterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Author:DELL
 * Date : 2018/8/28
 **/
@Data
public class User implements Serializable {
    /**
     * 用户标识
     */
    private Integer id;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户登录密码
     */
    private String loginPassword;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户身份证号码
     */
    private String idCard;
    /**
     * 注册时间
     */
    private Date addTime;
    /**
     * 最近一次的登录时间
     */
    private Date lastLoginTime;
    /**
     * 用户头像文件地址
     */
    private String headerImage;

}
