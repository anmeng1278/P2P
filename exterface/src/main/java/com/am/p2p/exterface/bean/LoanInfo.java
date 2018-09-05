package com.am.p2p.exterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 金融产品信息实体
 * Author:DELL
 * Date : 2018/8/28
 **/
@Data
public class LoanInfo implements Serializable {
    /**
     * 产品标识
     */
    private Integer id;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品年化利率
     */
    private Double rate;
    /**
     * 产品投资周期：新手宝产品单位为天，优选和散标产品单位为月
     */
    private Integer cycle;
    /**
     * 产品发布时间
     */
    private Date releaseTime;
    /**
     * 产品类型： 0新手宝产品，1优选类产品，2散标类产品
     */
    private Integer productType;
    /**
     * 产品编号
     */
    private String productNo;
    /**
     * 产品金额，即产品募集金额
     */
    private Double productMoney;
    /**
     * 产品剩余可投金额
     */
    private Double leftProductMoney;
    /**
     * 产品最少投资额
     */
    private Double bidMinLimit;
    /**
     * 产品最多投资额
     */
    private Double bidMaxLimit;
    /**
     * 产品状态：0未满标，1已满标，2满标已生成收益计划
     */
    private Integer productStatus;
    /**
     * 产品投资满标时间
     */
    private Date productFullTime;
    /**
     * 产品描述
     */
    private String productDesc;

    /**
     * 版本号  乐观锁
     */
    private Integer version;

}
