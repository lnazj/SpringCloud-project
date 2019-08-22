package com.dmsdbj.order.controller;

import com.dmsdbj.order.dto.OrderDTO;
import com.dmsdbj.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@RestController
@Api(description = "订单")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @ApiOperation("创建订单")
    @PostMapping("/create")
    public void create(@RequestBody OrderDTO orderDTO){

        orderService.create(orderDTO);
    }
}
