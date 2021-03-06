package com.willshuhua.adibioadmin.web;

import com.willshuhua.adibioadmin.define.OrderStatus;
import com.willshuhua.adibioadmin.dto.common.Result;
import com.willshuhua.adibioadmin.dto.order.OrderQuery;
import com.willshuhua.adibioadmin.entity.order.*;
import com.willshuhua.adibioadmin.service.ExpressageService;
import com.willshuhua.adibioadmin.service.OrderService;
import com.willshuhua.adibioadmin.service.PatientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    ExpressageService expressageService;
    @Autowired
    PatientService patientService;

    private Logger logger = Logger.getLogger(OrderController.class);

    @RequestMapping(value = "/latest_orders", method = RequestMethod.GET)
    public Object latestOrders(HttpServletRequest request){
        int limit = Integer.valueOf(request.getParameter("limit"));
        String status = request.getParameter("status");

        if ("ALL".equals(status)){
            status = "%";
        }

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
        if ("ALL".equals(status)){
            status = "%";
        }

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

    @RequestMapping(value = "/infoid_to_orderid", method = RequestMethod.GET)
    public Object infoToOrderid(@RequestParam("infoid")String infoId){
        return new Result(Result.OK, orderService.selectOrderIdByOrderInfoid(infoId));
    }

    @RequestMapping(value = "/latest_cashback", method = RequestMethod.GET)
    public Object latestNeedCashback(@RequestParam("limit") String limit, @RequestParam("paid")String paid){
        List<Object> cashList = orderService.selectLatestCashbackInfo(Integer.valueOf(limit), Boolean.valueOf(paid));
        return new Result(Result.OK, cashList);
    }

    @RequestMapping(value = "/part_cashback", method = RequestMethod.GET)
    public Object partNeedCashback(@RequestParam("limit") String limit, @RequestParam("start_row")String start_row, @RequestParam("paid") String paid){
        List<Object> cashList = orderService.selectPartCashbackInfo(Integer.valueOf(limit), Long.valueOf(start_row), Boolean.valueOf(paid));
        return new Result(Result.OK, cashList);
    }

    @RequestMapping(value = "/paid_cashback", method = RequestMethod.GET)
    public Object paidCashback(@RequestParam("share_id")String shareId){
        orderService.updateShareIsPaid(shareId, true);
        return new Result(Result.OK);
    }

    @RequestMapping(value = "/update_expressage", method = RequestMethod.POST)
    public Object updateExpressage(@RequestBody Expressage expressage){
        OrderInfo orderInfo = orderService.selectOrderInfo(expressage.getOrder_infoid());
        if (orderInfo == null){
            return new Result(Result.ERR, "Can't the order info!");
        }
        Expressage oldExpressage = expressageService.selectExpressage(expressage.getExpressage_id());
        if (oldExpressage == null){
            Map<String, String> orderIdMap = orderService.selectOrderIdByOrderInfoid(expressage.getOrder_infoid());
            expressage.setExpressage_id(UUID.randomUUID().toString());
            expressageService.insertExpressage(expressage);

            OrderEvent orderEvent = new OrderEvent();
            orderEvent.setOrder_eventid(UUID.randomUUID().toString());
            orderEvent.setEvent_title(OrderStatus.DELIVERED);
            orderEvent.setEvent_time(new Date());
            orderEvent.setOrder_id(orderIdMap.get("order_id"));
            orderEvent.setEvent_executor("admin");
            orderService.changeOrderStatus(orderEvent);
        }else{
            expressageService.updateExpressage(expressage);
        }
        return new Result();
    }

    @RequestMapping(value = "/expressage_info", method = RequestMethod.GET)
    public Object expressageInfo(@RequestParam("order_infoid")String orderInfoId){
        OrderInfo orderInfo = orderService.selectOrderInfo(orderInfoId);
        if (orderInfo == null){
            return new Result(Result.ERR, "Can't the order info!");
        }
        Expressage expressage = expressageService.selectExpressageByOrderInfoid(orderInfoId);
        return new Result(Result.OK, expressage);
    }

    @RequestMapping(value = "/update_order_patient", method = RequestMethod.POST)
    public Object updateOrderPatient(@RequestBody OrderPatientInfo orderPatientInfo){
        OrderPatientInfo orderPatientInfo1 = patientService.selectOrderPatientInfoByOrderPatientInfoId(orderPatientInfo.getOrder_patient_infoid());
        if (orderPatientInfo1 == null){
            return new Result(Result.ERR, "Can't find the order patient info!");
        }
        patientService.updateOrderPatientInfo(orderPatientInfo);
        return new Result(Result.OK, orderPatientInfo);
    }
}
