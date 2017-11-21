package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.entity.analysis.Analysis;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.entity.order.OrderInfo;
import com.willshuhua.adibioadmin.service.AnalysisService;
import com.willshuhua.adibioadmin.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
public class AnalysisController {

    @Autowired
    AnalysisService analysisService;
    @Autowired
    OrderService orderService;

    private Logger logger = Logger.getLogger(AnalysisController.class);

    @RequestMapping(value = "/create_analysis", method = RequestMethod.POST)
    public Object createAnalysis(@ModelAttribute("analysis")Analysis analysis){
        logger.info(analysis);
        Map<String, String> orderMap = orderService.selectOrderIdByOrderInfoid(analysis.getOrder_infoid());
        logger.info(orderMap);
        if (orderMap != null && orderMap.get("order_id") != null && !orderMap.get("order_id").equals("")){
            analysis.setAnalysis_id(UUID.randomUUID().toString());
            analysisService.insertAnalysis(analysis);
            return new Result();
        }else {
            return new Result(Result.ERR, "can't find the order_infoid");
        }
    }

    @RequestMapping(value = "/analysis_info", method = RequestMethod.GET)
    public Object analysisInfo(@RequestParam("order_infoid")String orderInfoid){
        OrderInfo orderInfo = orderService.selectOrderInfo(orderInfoid);
        if (orderInfo == null){
            return new Result(Result.ERR, "", null);
        }
        Map<String, Object> analysisInfo = analysisService.getAnalysisInfo(orderInfoid);
        if (analysisInfo == null){
            return new Result(Result.OK, "", null);
        }else {
            return new Result(Result.OK, analysisInfo);
        }
    }

    @RequestMapping(value = "/update_analysis", method = RequestMethod.POST)
    public Object updateAnalysis(@RequestBody Analysis analysis){
        logger.info(analysis);
        Map<String, Object> analysisInfo = analysisService.getAnalysisInfo(analysis.getOrder_infoid());
        logger.info(analysisInfo);
        if (analysisInfo == null){
            return new Result(Result.ERR, "Can't find the analysis information!");
        }
        analysisService.updateAnalysis(analysis);
        return new Result(Result.OK);
    }

    @RequestMapping(value = "/delete_analysis", method = RequestMethod.POST)
    public Object deleteAnalysis(@RequestParam("analysis_id")String analysisId){
        analysisService.deleteAnalysis(analysisId);
        return new Result();
    }
}
