package com.jiangfan.springcloud.dao;

import com.jiangfan.springcloud.entitys.Payment;
import org.apache.ibatis.annotations.*;

/**
 * ClassName: PaymentDao
 * Description:
 * date: 2020-8-2 22:28
 *
 * @author LENOVO
 * @since JDK 1.8
 */
@Mapper
public interface PaymentDao {
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into payment (serial) values(#{serial})")
    public Integer insertPayment(Payment payment);

    @Select("select  * from  payment  where  id=#{id}")
    public Payment getPaymentById(@Param("id") Long id);


}
