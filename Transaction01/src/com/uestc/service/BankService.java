package com.uestc.service;

import java.math.BigDecimal;

import com.uestc.model.AccountIdentity;


public interface BankService {
    
    void transfer(AccountIdentity from, AccountIdentity to, BigDecimal amount);

    BigDecimal getBalance(AccountIdentity accountIdentity);

}
