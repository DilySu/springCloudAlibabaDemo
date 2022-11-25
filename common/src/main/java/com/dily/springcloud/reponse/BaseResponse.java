package com.dily.springcloud.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2022-10-27 星期四
 * Time: 13:55
 * Author: Dily_Su
 * Remark:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {

    private Integer code;
    private String message;
    private T data;

    public BaseResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

}
