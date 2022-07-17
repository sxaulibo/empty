package com.sxau.empty;

import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@Slf4j
@RestController
public class Controller {

    @PostMapping("/refund/{orderId}/{amount}")
    public void refund(@PathVariable String orderId, @PathVariable int amount) {
        log.info("订单：" + orderId + "退款" + amount + "元 ");
    }

    @PostMapping("/refund/{messageId}/{orderId}/{amount}")
    public void refund(@PathVariable String messageId, @PathVariable String orderId, @PathVariable int amount) {
        if (extracted(messageId)) {
            return;
        }

        log.info("订单：" + orderId + "退款" + amount + "元 ");
    }


    private synchronized boolean extracted(String messageId) {
        if (refund.contains(messageId)) {
            log.warn(RefundEnum.REPEAT.getDesc());
            return true;
        }

        refund.add(messageId);
        return false;
    }

    private static final HashSet<String> refund = new HashSet<>();

}
