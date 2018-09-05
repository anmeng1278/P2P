package com.am.p2p.exterface.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 投资信息表
 * Author:DELL
 * Date : 2018/8/28
 **/
@Data
public class BidInfo implements Serializable {
    /**
     * 投资记录标识
     */
    private Integer id;
    /**
     * 投资金额
     */
    private Double bidMoney;
    /**
     * 投资时间
     */
    private Date bidTme;
    /**
     * 投资状态：0投资失败，1投资成功
     */
    private Integer bidStatus;
    /**
     * 关联属性：投资产品信息
     */
    private LoanInfo loanInfo;
    /**
     * 关联属性：投资人信息
     */
    private User user;

}
