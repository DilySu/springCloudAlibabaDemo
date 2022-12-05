package com.dily.springcloud.controller;

import com.dily.springcloud.reponse.BaseResponse;
import com.dily.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Date: 2022-11-30 星期三
 * Time: 15:54
 * Author: Dily_Su
 * Remark:
 */
@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("decrease")
    public BaseResponse decrease(@RequestParam Long userId, @RequestParam BigDecimal money) {
        accountService.decrease(userId, money);
        return new BaseResponse<>(200, "扣减金额成功！");
    }

}
