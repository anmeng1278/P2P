package com.am.p2p.dataService.service.impl;

import com.am.p2p.dataService.dao.ILoanInfoDao;
import com.am.p2p.exterface.bean.LoanInfo;
import com.am.p2p.exterface.constant.Constans;
import com.am.p2p.exterface.service.ILoandInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Author:DELL
 * Date : 2018/8/30
 **/
@Service
public class LoandInfoServiceImpl implements ILoandInfoService {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private ILoanInfoDao loanInfoDao;

    @Transactional
    @Cacheable("realTimeCache")
    @Override
    public List<LoanInfo> findLoanInfoByProductTypeAndPage(Map<String,Object> map) {

        return loanInfoDao.selectLoanInfoByProductTypeAndPage(map);
    }


    @Transactional
    @Override
    public Double findHistoryAvgRate() {
        //获取redis操作对象
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps(Constans.REDIS_KEY_HISTORY_AVG_RATE);
        //从redis缓存中首次获得历史年化收益率
        Object historyAvgRate = ops.get();
        if(historyAvgRate == null){
            synchronized (this){
                //从redis缓存中再次获取历史年化收益率
                historyAvgRate = ops.get();
                if(historyAvgRate == null){
                    //从DB中查询
                    historyAvgRate = loanInfoDao.selectHistoryAvgRate();
                    //将查询结果放到redis
                    ops.set(historyAvgRate);
                    ops.expire(1,TimeUnit.HOURS);
                }
            }
        }

        return loanInfoDao.selectHistoryAvgRate();
    }

}
