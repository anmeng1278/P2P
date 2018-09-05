package com.am.p2p.web.handler;

import com.am.p2p.exterface.bean.LoanInfo;
import com.am.p2p.exterface.service.IBidInfoService;
import com.am.p2p.exterface.service.ILoandInfoService;
import com.am.p2p.exterface.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:DELL
 * Date : 2018/8/30
 **/
@Controller
public class IndexHandler {

    @Autowired
    private ILoandInfoService loandInfoService;

    @Autowired
    private IBidInfoService bidInfoService;

    @Autowired
    private IUserService userService;

    @RequestMapping("/index.do")
    public String indexHandle(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("pageStartIndex",0);

        // 查询新手宝产品（产品类型：0，页面大小1）， 将结果放到model
        map.put("productType",0);
        map.put("pageSize",1);
        List<LoanInfo> xinLoanInfos = loandInfoService.findLoanInfoByProductTypeAndPage(map);
        model.addAttribute("xinLoanInfos",xinLoanInfos);
        for(LoanInfo loanInfo : xinLoanInfos){
            System.out.println(loanInfo);
        }
        System.out.println("-----------------");

        // 查询优选类产品（产品类型：1，页面大小4）， 将结果放到model
        map.put("productType",1);
        map.put("pageSize",4);
        List<LoanInfo> youLoanInfos = loandInfoService.findLoanInfoByProductTypeAndPage(map);
        model.addAttribute("youLoanInfos",youLoanInfos);
        for(LoanInfo loanInfo : youLoanInfos){
            System.out.println(youLoanInfos);
        }
        System.out.println("-----------------");

        // 查询散标类产品（产品类型：2，页面大小8）， 将结果放到model
        map.put("productType",2);
        map.put("pageSize",8);
        List<LoanInfo> sanLoanInfos = loandInfoService.findLoanInfoByProductTypeAndPage(map);
        model.addAttribute("sanLoanInfos",sanLoanInfos);
        for(LoanInfo loanInfo : sanLoanInfos){
            System.out.println(sanLoanInfos);
        }
        System.out.println("-----------------");


        // 查询平台历史年收益率 ， 将结果放到model
        Double historyAvgRate = loandInfoService.findHistoryAvgRate();
        model.addAttribute("historyAvgRate");
        System.out.println("historyAvgRate="+historyAvgRate);


        // 查询平台注册总人数， 将结果放到model
        Long totalUserCount = userService.findTotalUserCount();
        model.addAttribute("totalUserCount");
        System.out.println("totalUserCount="+totalUserCount);


        // 查询平台总成交额， 将结果放到model
        Double totalBidCount = bidInfoService.findTotalBidCount();
        model.addAttribute("totalBidCount");
        System.out.println("totalBidCount="+totalBidCount);

        return "/index.jsp";
    }
}
