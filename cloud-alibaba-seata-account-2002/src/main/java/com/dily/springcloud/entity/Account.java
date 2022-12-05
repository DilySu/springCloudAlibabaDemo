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
 * Time: 15:55
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName
public class Account {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long userId;
    private BigDecimal total;
    private BigDecimal used;
    private BigDecimal residue;

}
