package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.Order;
import com.willshuhua.adibioadmin.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/latest_orders", method = RequestMethod.GET)
    public Object latestOrders(HttpServletRequest request){
        int limit = Integer.valueOf(request.getParameter("limit"));
        String status = request.getParameter("status");

        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setLimit(limit);
        orderQuery.setStatus(status);

        List<Order> orderList = orderService.selectLatestOrders(orderQuery);
        return new Result(Result.OK, orderList);
    }

    @RequestMapping(value = "/part_orders", method = RequestMethod.GET)
    public Object partOrders(HttpServletRequest request){
        int limit = Integer.valueOf(request.getParameter("limit"));
        String status = request.getParameter("status");
        long startRow = Long.valueOf(request.getParameter("start_row"));
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setStatus(status);
        orderQuery.setLimit(limit);
        orderQuery.setStart_row(startRow);
        List<Order> orderList = orderService.selectPartOrders(orderQuery);
        return new Result(Result.OK, orderList);
    }

    @RequestMapping(value = "/order_detail", method = RequestMethod.GET)
    public Object orderDetail(HttpServletRequest request){
        String orderId = request.getParameter("order_id");
        Map<String, Object> orderDetail = orderService.getOrderDetail(orderId);
        return new Result(Result.OK, orderDetail);
    }

//    TODO:根据order_infoid查询到订单的相关信息
//    @RequestMapping(value = "/info_to_orderid", method = RequestMethod.GET)
//    public Object infoToOrderid(@RequestParam("infoid")String infoId){
//
//    }

}
