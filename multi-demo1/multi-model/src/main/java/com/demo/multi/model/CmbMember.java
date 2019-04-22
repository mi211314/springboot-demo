package com.demo.multi.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CmbMember {

    private BigDecimal mid;

    private String mbPhone;

    private String mbName;

    private String mbPassword;

    private String mbPayPwd;

    private String mbSalt;

    private String mbRealname;

    private String mbIdentity;

    private Short mbIdcertStatus;

    private Date mbIdcertTime;

    private Short mbStatus;

    private Date mbBirthday;

    private Short mbBirthdayType;

    private Short mbSex;

    private String mbRecommendCode;

    private String mbPhoto;

    private String mbSchool;

    private String mbGrade;

    private Date createTime;

    private Date updateTime;

    private Short delFlag;

    private BigDecimal mbVipcard;

    private BigDecimal mbRegType;

    private BigDecimal mbType;

    private BigDecimal merid;

    private String mbEncryptKey;

    private String nickName;

}