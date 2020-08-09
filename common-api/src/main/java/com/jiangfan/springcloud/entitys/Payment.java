package com.jiangfan.springcloud.entitys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: Payment
 * Description:
 * date: 2020-8-2 22:06
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Data
@AllArgsConstructor //有参数构造
@NoArgsConstructor  //无参构造
public class Payment implements Serializable {
    private Long id;
    private  String serial;

}
