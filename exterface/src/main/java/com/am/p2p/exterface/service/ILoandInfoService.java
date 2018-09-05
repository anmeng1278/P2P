package com.am.p2p.exterface.service;

import com.am.p2p.exterface.bean.LoanInfo;

import java.util.List;
import java.util.Map;

/**
 * Author:DELL
 * Date : 2018/8/30
 **/

public interface ILoandInfoService {

    /**
     * 查询平台历史年化收益率
     * @return
     */
    Double findHistoryAvgRate();


    /**
     * 根据产品类型与页面大小查询指定产品信息
     * @param map
     * @return
     */
    List<LoanInfo> findLoanInfoByProductTypeAndPage(Map<String,Object> map);
}
