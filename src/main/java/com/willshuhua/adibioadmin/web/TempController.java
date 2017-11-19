package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.service.OrderService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TempController {

    private Logger logger = Logger.getLogger(TempController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/barcode", method = RequestMethod.GET)
    public ModelAndView  barcode(@RequestParam("order_id")String orderId){
        Map<String, Object> orderMap = orderService.getOrderDetail(orderId);
        ModelAndView modelAndView = new ModelAndView("/barcode");
        modelAndView.addObject("infos", orderMap.get("infos"));
        logger.info(orderMap);
        return modelAndView;
    }
}
