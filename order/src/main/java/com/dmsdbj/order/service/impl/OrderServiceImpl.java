package com.dmsdbj.order.service.impl;

import com.dmsdbj.order.client.ProductClient;
import com.dmsdbj.order.dataobject.OrderDetail;
import com.dmsdbj.order.dataobject.OrderMaster;
import com.dmsdbj.order.dataobject.ProductInfo;
import com.dmsdbj.order.dto.CartDTO;
import com.dmsdbj.order.dto.OrderDTO;
import com.dmsdbj.order.enums.OrderStatusEnum;
import com.dmsdbj.order.enums.PayStatusEnum;
import com.dmsdbj.order.repository.OrderDetailRepository;
import com.dmsdbj.order.repository.OrderMasterRepository;
import com.dmsdbj.order.service.OrderService;
import com.dmsdbj.order.utils.KeyUtil;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.Key;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;


    @Override
    /**
     * 1. 查询商品信息(调用商品服务)
     * 2. 计算总价
     * 3. 扣库存(调用商品服务)
     * 4. 订单入库
     */
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId= KeyUtil.genUniqueKey();
        // 查询商品信息(调用商品服务)
        List<String> productIdList=orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfo> productInfoList=productClient.findList(productIdList);

         // 计算总价
        BigDecimal orderAmout=new BigDecimal(BigInteger.ZERO);
        for(OrderDetail orderDetail:orderDTO.getOrderDetailList()){
            for(ProductInfo productInfo:productInfoList){
                if(productInfo.getProductId().equals(orderDetail.getProductId())){
                    orderAmout=productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmout);
                    BeanUtils.copyProperties(productInfo,orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetailRepository.save(orderDetail);
                }
            }
        }

        // 扣库存(调用商品服务)
        List<CartDTO> cartDTOList=orderDTO.getOrderDetailList().stream()
                .map(e -> new CartDTO(e.getProductId(),e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(cartDTOList);

       //  订单入库
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(orderAmout);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }
}
