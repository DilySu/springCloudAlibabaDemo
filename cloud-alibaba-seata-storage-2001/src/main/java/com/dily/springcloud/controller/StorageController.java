package com.dily.springcloud.controller;

import com.dily.springcloud.reponse.BaseResponse;
import com.dily.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:36
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("storage")
public class StorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("decrease")
    public BaseResponse decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return new BaseResponse<>(200,"扣减库存成功");
    }

}
