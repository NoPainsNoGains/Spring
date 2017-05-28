package com.uetsc.util;

import org.springframework.core.NestedRuntimeException;

import com.uestc.model.AccountIdentity;


public class UnknownAccountException extends NestedRuntimeException {
    private static final long serialVersionUID = -5705813683661824922L;
    private AccountIdentity identity;

    public UnknownAccountException(AccountIdentity identity) {
        super("Unknown account");
        this.identity = identity;
    }

    public AccountIdentity getIdentity() {
        return identity;
    }
}
