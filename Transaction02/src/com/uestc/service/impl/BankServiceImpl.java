package com.uestc.service.impl;

import java.util.List;

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
    private PlatformTransactionManager  transactionManager;
    
	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

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
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus transactionStatus= this.transactionManager.getTransaction(transactionDefinition);
		try{
			bankDaoImpl.save();//人工抛异常
			this.transactionManager.commit(transactionStatus);
		}catch(Exception e){
			System.out.println("异常 事务回滚");
			this.transactionManager.rollback(transactionStatus);
		}
	}

	@Override
	public void updateService() {
        TransactionTemplate transactionTemplate = TransactionTemplateUtils.getDefaultTransactionTemplate(transactionManager);  
        transactionTemplate.execute(new TransactionCallbackWithoutResult(){  
            @Override  
            protected void doInTransactionWithoutResult(TransactionStatus status) {  
                try{  
                	bankDaoImpl.update();  
                }catch(Exception e){  
                    status.setRollbackOnly();  
                    e.printStackTrace();  
                }  
            }  
              
        });  
	}
	
}
