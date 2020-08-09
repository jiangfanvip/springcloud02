package com.jiangfan.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName: CommonResult
 * Description:
 * date: 2020-8-2 22:21
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String mesage;
    private T data;

    public CommonResult(Integer code, String mesage) {
        this.code = code;
        this.mesage = mesage;
    }
}
