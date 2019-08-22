package com.example.product.exception;


import com.example.product.enums.ResultEnum;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-21
 */
public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(Integer code,String  message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }
}
