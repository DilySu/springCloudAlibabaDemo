package com.dily.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Date: 2022-11-30 星期三
 * Time: 14:20
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    // 订单状态  0：创建中，1：已完结
    private Integer status;

}
