package cn.cie.controller;

import cn.cie.services.OrderService;
import cn.cie.utils.Result;
import cn.cie.utils.UserHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by RojerAlone on 2017/6/12.
 */
@CrossOrigin
@Controller
@RequestMapping(value = "/order")
public class OrderController extends AbstractController{

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserHolder userHolder;

    @PostMapping(value = "order")
    public Result order(List<Integer> games) {
        return orderService.addOrders(userHolder.getUser().getId(), games);
    }

    @PostMapping(value = "{orderid}/cancel")
    public Result cancelOrder(@PathVariable(value = "orderid") Integer orderid) {
        return orderService.cancelOrder(userHolder.getUser().getId(), orderid);
    }

    @PostMapping(value = "{orderid}/pay")
    public Result payOrder(@PathVariable(value = "orderid") Integer orderid) {
        return orderService.pay(userHolder.getUser().getId(), orderid);
    }

    @PostMapping(value = "notpay")
    public Result getNotPayOrders() {
        return orderService.getNotPayOrders(userHolder.getUser().getId());
    }

    @PostMapping(value = "paid")
    public Result getPaidOrders() {
        return orderService.getPaidOrders(userHolder.getUser().getId());
    }

    @PostMapping(value = "cancel")
    public Result getCancelOrders() {
        return orderService.getCancelOrders(userHolder.getUser().getId());
    }

}