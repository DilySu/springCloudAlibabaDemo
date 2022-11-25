package com.dily.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dily.springcloud.reponse.BaseResponse;

/**
 * Date: 2022-11-24 星期四
 * Time: 15:00
 * Author: Dily_Su
 * Remark: 全局的熔断降级处理
 */
public class CustomerBlockHandler {

    public static BaseResponse handlerException(BlockException e){
        return new BaseResponse<>(444,"按客户自定义，global handlerException ---1");
    }

    public static BaseResponse handlerException2(BlockException e){
        return new BaseResponse<>(444,"按客户自定义，global handlerException ---2");
    }
}
