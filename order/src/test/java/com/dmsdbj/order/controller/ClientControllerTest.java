package com.dmsdbj.order.controller;

//import com.dmsdbj.order.client.ProductClient;
import com.dmsdbj.order.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-21
 */
@Component
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientControllerTest {

    @Resource
//    private ProductClient productClient;

    @Test
    public void findList() throws Exception {
//        List<ProductInfo> list= productClient.findList(Arrays.asList("1"));
//        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock() throws Exception {
    }
}