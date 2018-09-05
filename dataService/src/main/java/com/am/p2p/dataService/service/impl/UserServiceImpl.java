package com.am.p2p.dataService.service.impl;

import com.am.p2p.dataService.dao.IUserDao;
import com.am.p2p.exterface.constant.Constans;
import com.am.p2p.exterface.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
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
public class UserServiceImpl implements IUserService {

    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    @Autowired
    private IUserDao userDao;

    @Transactional
    @Override
    public Long findTotalUserCount() {
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps(Constans.REDIS_KEY_TOTAL_USER_COUNT);
        Object totalUserCount = ops.get();
        if(totalUserCount == null){
            synchronized (this){
                totalUserCount = ops.get();
                if(totalUserCount == null){
                    totalUserCount = userDao.selectTotalCount();
                    ops.set(totalUserCount,1,TimeUnit.HOURS);
                }
            }
        }

        return userDao.selectTotalCount();
    }
}
