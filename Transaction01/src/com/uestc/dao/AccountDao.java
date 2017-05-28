package com.uestc.dao;

import com.uestc.model.Account;
import com.uestc.model.AccountIdentity;

public interface AccountDao {
    void save(Account account);
    Account getByIdentity(AccountIdentity accountIdentity);
}
