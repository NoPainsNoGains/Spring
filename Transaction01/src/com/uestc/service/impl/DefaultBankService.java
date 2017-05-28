package com.uestc.service.impl;


import java.math.BigDecimal;

import com.uestc.model.AccountIdentity;
import com.uestc.service.BankService;
import com.uestc.service.BankServiceSupport;

public class DefaultBankService extends BankServiceSupport
        implements BankService {

    public void transfer(AccountIdentity from, AccountIdentity to,
                         BigDecimal amount) {
        if (getBalance(to).compareTo(new BigDecimal("1000000000")) > 0) {
            throw new RuntimeException("Billionaires do not need more money!");
        }
        doTransfer(from, to, amount);
    }

    public BigDecimal getBalance(AccountIdentity accountIdentity) {
        return doGetBalance(accountIdentity);
    }
}