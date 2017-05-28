package com.uestc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uestc.model.AccountIdentity;
import com.uestc.service.BankService;

import java.math.BigDecimal;

/**
 * @author janm
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext(
                new String[] {
                        "/*-context.xml",
                        "/*-context-nt.xml"
                }
        );
        BankService bankService = (BankService) ac.getBean("bankService");
        final AccountIdentity a1 = new AccountIdentity("011001", "12345678");
        final AccountIdentity a2 = new AccountIdentity("011001", "10203040");

        System.out.println("Before");
        System.out.println(a1 + ": " + bankService.getBalance(a1));
        System.out.println(a2 + ": " + bankService.getBalance(a2));
        bankService.transfer(a1, a2, new BigDecimal("200.00"));
        System.out.println("After");
        System.out.println(a1 + ": " + bankService.getBalance(a1));
        System.out.println(a2 + ": " + bankService.getBalance(a2));
    }

}
