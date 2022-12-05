package com.dily.springcloud.feign;

import com.dily.springcloud.reponse.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:18
 * Author: Dily_Su
 * Remark:
 */
@FeignClient("seata-account")
public interface AccountFeign {
    @PostMapping("/account/decrease")
    BaseResponse decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
