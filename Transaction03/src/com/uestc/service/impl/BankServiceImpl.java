package com.uestc.service.impl;

import java.util.List;

import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.uestc.dao.BankDao;
import com.uestc.model.Account;
import com.uestc.service.BankService;
import com.uestc.util.TransactionTemplateUtils;

public class BankServiceImpl implements BankService{
    private BankDao bankDaoImpl;

	public BankDao getBankDaoImpl() {
		return bankDaoImpl;
	}

	public void setBankDaoImpl(BankDao bankDaoImpl) {
		this.bankDaoImpl = bankDaoImpl;
	}

	@Override
	public List<Account> listService() {
		List<Account> list =  bankDaoImpl.list();
		return list;
	}

	@Override
	public void saveService() {
		
		bankDaoImpl.save();//人工抛异常
		throw new RuntimeException(); 
	}

	@Override
	public void updateService() {
         bankDaoImpl.update();      
	}
	
}
