package com.dily.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Date: 2022-11-21 星期一
 * Time: 15:36
 * Author: Dily_Su
 * Remark:
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receiveMessage (Message<String> message){

        log.info("消费者2：----------> " + message.getPayload()+"\t port：" + port);
    }
}


