package com.dily.springcloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dily.springcloud.entity.Account;
import org.apache.ibatis.annotations.Mapper;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:55
 * Author: Dily_Su
 * Remark:
 */
@Mapper
public interface AccountMapper extends BaseMapper<Account> {
}
