package com.dmsdbj.order.client;

import com.dmsdbj.order.dataobject.ProductInfo;
import com.dmsdbj.order.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 客户端做操作，服务端不用,定义好要调用的接口
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@FeignClient(name="PRODUCT" )  // 要调用的服务的名称
public interface ProductClient {
    @GetMapping(value = "/product/msg")
    String productMsg();

    @PostMapping(value = "/product/findList")
    List<ProductInfo> findList(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<CartDTO> cartDTOList);
}
