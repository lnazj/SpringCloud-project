package com.dmsdbj.order.controller;

import com.dmsdbj.order.dataobject.ProductInfo;
import com.dmsdbj.order.dto.CartDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * resttemplate的方式
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@RestController
@RequestMapping("Order")
public class ClientController {

    //第二种方式：
     @Autowired
     private LoadBalancerClient loadBalancerClient;

    //第三种注解@loadbalance
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand()
    @GetMapping("getProduct")
    public String getProductMsg() {

//         //1.第一种方式基于restTemplate url，弊端多个服务实例无法实现负载均衡
//        RestTemplate restTemplate=new RestTemplate();
//        String msg=restTemplate.getForObject("http://localhost:8081/product/msg",String.class);
//        System.out.println(msg);
//
//        // 2. 利用loadBalancerClient 通过应用名获取url
//        RestTemplate restTemplate=new RestTemplate();
//        ServiceInstance serviceInstance=loadBalancerClient.choose("PRODUCT");
//        String url=String.format("http://%s:%s", serviceInstance.getHost(),serviceInstance.getPort())+"product/msg";
//        String response=restTemplate.getForObject(url,String.class);
//        return response;

         //3. 基于loadbalance注解
        String response=restTemplate.getForObject("http://PRODUCT/product/msg",String.class);
        return response;
    }


}

/*
 * 基于feign
 */
//@RestController
//@RequestMapping("Order")
//@Api(description = "订单")
//public class ClientController {

//  @Autowired
//  ProductClient productClient;
//
//    @GetMapping("/getProduct")
//    public String getProductMsg(){
//        String response=productClient.productMsg();
//        return response;
//    }
//
//  @PostMapping("/findList")
//  public List<ProductInfo> findList(@RequestBody List<String> productIdList){
//     return productClient.findList(productIdList);
//  }
//
//    @PostMapping("/decreaseStock")
//   public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
//        System.out.println("aaaa");
//       productClient.decreaseStock(cartDTOList);
//    }
