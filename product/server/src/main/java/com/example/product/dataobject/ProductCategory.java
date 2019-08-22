package com.example.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by 廖师兄
 * 2017-12-09 21:37
 */
@Data
/** 这个对象和数据表做对应. */
@Entity
public class ProductCategory {

    /** 主键. */
    @Id
    /** 自增. */
    @GeneratedValue
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
