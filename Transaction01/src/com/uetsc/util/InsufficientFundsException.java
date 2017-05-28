package com.uetsc.util;

import org.springframework.core.NestedRuntimeException;

import java.math.BigDecimal;


public class InsufficientFundsException extends NestedRuntimeException {
    private static final long serialVersionUID = -1594135094048647795L;
    private BigDecimal required;

    public InsufficientFundsException(BigDecimal required) {
        super("Insufficient funds");
        this.required = required;
    }

    public BigDecimal getRequired() {
        return required;
    }
}
