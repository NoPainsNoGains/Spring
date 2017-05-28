package com.uestc.dao;

import java.util.List;

import com.uestc.model.Account;

public interface BankDao {
	public List<Account> list();
	public void save();
	public void update();
}
