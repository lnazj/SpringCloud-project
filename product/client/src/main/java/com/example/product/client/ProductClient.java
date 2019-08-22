package com.example.product.client;

import com.example.product.common.DecreaseStockInput;
import com.example.product.common.ProductInfoOutput;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 对外暴露服务的接口
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-21
 */
@FeignClient(name="product")
public interface ProductClient {

    @PostMapping("/product/findList")
    List<ProductInfoOutput> findList(@RequestBody List<String> productIdList);

    @PostMapping("/product/descreaseStock")
    void descreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
