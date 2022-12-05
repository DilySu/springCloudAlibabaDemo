package com.dily.springcloud.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dily.springcloud.entity.Storage;
import com.dily.springcloud.mapper.StorageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:14
 * Author: Dily_Su
 * Remark:
 */
@Service
@Slf4j
public class StorageService extends ServiceImpl<StorageMapper, Storage> {

    public void decrease(Long productId, Integer count) {
        log.info("--------------storage 扣减库存开始");
        Storage storage = this.getOne(new LambdaQueryWrapper<Storage>().eq(Storage::getProductId, productId));
        this.update(new LambdaUpdateWrapper<Storage>()
                .eq(Storage::getProductId, productId)
                .set(Storage::getUsed, storage.getUsed() + count) // 已用库存增加
                .set(Storage::getResidue, storage.getResidue() - count) // 剩余库存减少
        );
        log.info("--------------storage 扣减库存结束");
    }

}
