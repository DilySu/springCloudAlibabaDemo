package com.dily.springcloud.service.impl;

import com.dily.springcloud.service.MessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * Date: 2022-11-21 星期一
 * Time: 14:19
 * Author: Dily_Su
 * Remark: 与 Stream 中的 binding 关联
 */
@EnableBinding(Source.class) // 定义消息的推送，即 stream
@Slf4j
public class MessageProviderImpl implements MessageProvider {

    @Resource // 信道
    private MessageChannel output;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(uuid).build());
        log.info("***********************uuid:" + uuid);
        return uuid;
    }
}
