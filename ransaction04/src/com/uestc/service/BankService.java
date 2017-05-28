package com.uestc.service;

import java.util.List;

import com.uestc.model.Account;

public interface BankService {
	public List<Account> listService();
	public void saveService();
	public void updateService();
}
