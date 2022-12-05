package com.dily.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:13
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName
public class Storage {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
