package com.am.p2p.dataService.test;

import com.am.p2p.exterface.service.IBidInfoService;
import com.am.p2p.exterface.service.ILoandInfoService;
import com.am.p2p.exterface.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author:DELL
 * Date : 2018/8/31
 **/
public class serviceTest {

    IBidInfoService bidInfoService;
    ILoandInfoService loadInfoService;
    IUserService userService;


    @Before
    public void before(){

        String conf1 = "spring-ds.xml";
        String conf2 = "spring-mybatis.xml";
        String conf3 = "spring-provider.xml";
        String conf4 = "spring-redis.xml";
        String conf5 = "spring-service.xml";
        String conf6 = "spring-tx.xml";
        String[] confs = {conf1,conf2,conf3,conf4,conf5,conf6};
        ApplicationContext ac = new ClassPathXmlApplicationContext(confs);

        bidInfoService = ac.getBean(IBidInfoService.class);

        loadInfoService = ac.getBean(ILoandInfoService.class);

        userService = ac.getBean(IUserService.class);
    }

    @Test
    public void test01(){
        Long totalUserCount = userService.findTotalUserCount();
        System.out.println(totalUserCount);
    }

}
