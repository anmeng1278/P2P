package com.am.p2p.dataService.service.impl;

import com.am.p2p.dataService.dao.IBidInfoDao;
import com.am.p2p.exterface.constant.Constans;
import com.am.p2p.exterface.service.IBidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * Author:DELL
 * Date : 2018/8/30
 **/
@Service
public class BidInfoServiceImpl implements IBidInfoService {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private IBidInfoDao bidInfoDao;

    @Transactional
    @Override
    public Double findTotalBidCount() {

        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps(Constans.REDIS_KEY_TOTAL_BID_AMOUNT);

        Object totalBidAmount = ops.get();
        if(totalBidAmount == null){
            synchronized (this){
                totalBidAmount = ops.get();
                if(totalBidAmount == null){
                    totalBidAmount = bidInfoDao.selectTotalBidAmount();
                    ops.set(totalBidAmount,1,TimeUnit.HOURS);
                }
            }
        }

        return bidInfoDao.selectTotalBidAmount();
    }
}
