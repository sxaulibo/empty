package com.sxau.empty;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RefundEnum {

    /**
     * 退款
     */
    REPEAT(201, "重复退款");

    private final int value;
    private final String desc;

}
