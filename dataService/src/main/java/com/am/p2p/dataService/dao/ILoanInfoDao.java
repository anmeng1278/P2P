package com.am.p2p.dataService.dao;

import com.am.p2p.exterface.bean.LoanInfo;

import java.util.List;
import java.util.Map;

/**
 * Author:DELL
 * Date : 2018/8/29
 **/
public interface ILoanInfoDao {

    Double selectHistoryAvgRate();

    List<LoanInfo> selectLoanInfoByProductTypeAndPage(Map<String,Object> map);
}
