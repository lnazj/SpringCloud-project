package com.example.product.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-08-20
 */
@Data
public class ResultVO<T> {
    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 具体内容
     */
    private T data;
}
