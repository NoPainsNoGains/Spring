package com.uestc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.uestc.dao.BankDao;
import com.uestc.model.Account;
import com.uestc.service.BankService;
@Transactional
@Component("bankServiceImpl")
public class BankServiceImpl implements BankService{
    private BankDao bankDaoImpl;

	public BankDao getBankDaoImpl() {
		return bankDaoImpl;
	}
	@Resource(name="bankDaoImpl")
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
