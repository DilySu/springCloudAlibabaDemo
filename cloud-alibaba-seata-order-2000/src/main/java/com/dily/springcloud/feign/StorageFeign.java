package com.dily.springcloud.feign;

import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:18
 * Author: Dily_Su
 * Remark:
 */
@FeignClient("seata-storage")
public interface StorageFeign {
    @PostMapping("/storage/decrease")
    BaseResponse decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
