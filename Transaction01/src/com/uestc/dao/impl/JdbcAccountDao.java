package com.uestc.dao.impl;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import com.uestc.dao.AccountDao;
import com.uestc.model.Account;
import com.uestc.model.AccountIdentity;

import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcAccountDao extends SimpleJdbcDaoSupport implements AccountDao {
    private static final String INSERT_SQL =
            "insert into account (id, sort_code, number, balance) values " +
                    "(?, ?, ?, ?)";
    private static final String UPDATE_SQL =
            "update account set balance=? where id=?";
    private static final String SELECT_SQL =
            "select id, sort_code, number, balance from account " +
                    "where sort_code=? and number=?";

    public void save(Account account) {
      
        if (account.getId() == null) {
            // insert
            getSimpleJdbcTemplate().update(INSERT_SQL,
                    account.getId(),
                    account.getIdentity().getSortCode(),
                    account.getIdentity().getNumber(),
                    account.getBalance());
        } else {
            // update
            getSimpleJdbcTemplate().update(UPDATE_SQL,
                    account.getBalance(),
                    account.getId());
        }
    }

    public Account getByIdentity(AccountIdentity accountIdentity) {
        return getSimpleJdbcTemplate().queryForObject(SELECT_SQL,
                new ParameterizedBeanPropertyRowMapper<Account>() {
                    public Account mapRow(ResultSet rs, int rowNumber)
                            throws SQLException {
                        Account account = new Account();
                        account.setId(rs.getLong(1));
                        AccountIdentity identity = new AccountIdentity(
                                rs.getString(2),
                                rs.getString(3)
                        );
                        account.setIdentity(identity);
                        account.setBalance(rs.getBigDecimal(4));
                        return account;
                    }
                }, accountIdentity.getSortCode(), accountIdentity.getNumber());
    }
}
