package com.uestc.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.uestc.dao.BankDao;
import com.uestc.model.Account;

public class BankDaoImpl extends JdbcDaoSupport implements BankDao{ 
	@Override
	public List<Account> list() {
		String sql = "select * from account";
		List<Account> list = this.getJdbcTemplate().queryForList(sql);
		return list;
	}

	@Override
	public void save() {
		/*插入*/
		String sql = "insert into account (id, sort_code, number, balance) values (?, ?, ?, ?)";
		Object[] params = new Object[] { new Integer(8), "rrrr", "1234", 3.14 };
		this.getJdbcTemplate().update(sql, params);	
	}

	@Override
	public void update() {
		String sql = "update account set balance=? where id=?";
		Object[] params = new Object[] {4.44 ,new Integer(8)};
		this.getJdbcTemplate().update(sql, params);	
		
	}
}
