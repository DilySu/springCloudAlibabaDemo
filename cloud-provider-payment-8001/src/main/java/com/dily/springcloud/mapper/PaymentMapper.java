package com.dily.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Date: 2022-10-27 星期四
 * Time: 14:16
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {
}
