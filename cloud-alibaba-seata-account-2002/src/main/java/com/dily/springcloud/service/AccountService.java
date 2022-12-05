package com.dily.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dily.springcloud.entity.Account;
import com.dily.springcloud.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:56
 * Author: Dily_Su
 * Remark:
 */
@Service
@Slf4j
public class AccountService extends ServiceImpl<AccountMapper, Account> {

    public void decrease(Long userId, BigDecimal money) {
        log.info("--------------account 扣减金额开始");
        Account account = this.getOne(new LambdaQueryWrapper<Account>().eq(Account::getUserId, userId));
        this.update(new LambdaUpdateWrapper<Account>()
                .eq(Account::getUserId, userId)
                .set(Account::getUsed, account.getUsed().add(money) ) // 已用库存增加
                .set(Account::getResidue, account.getResidue().subtract(money)) // 剩余库存减少
        );
        log.info("--------------account 扣减金额结束");
    }
}
