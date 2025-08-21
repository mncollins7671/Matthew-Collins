package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAccountDao implements AccountDao {
    private final String ACCOUNT_SQL_SELECT = "SELECT account_id, user_id, account_type, balance FROM account ";

    private final JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalanceByUserId(int userId) {
        String sql = "SELECT balance FROM account WHERE user_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, userId);

        }catch (Exception e){
            throw new DaoException("Error retrieving balance by user ID", e);
        }
    }

    public List<Integer> allAccounts(){
        List<Integer> accountIds = new ArrayList<>();
        String sql = "SELECT account_id FROM account";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            Integer accounts = results.getInt("account_id");
            accountIds.add(accounts);
        }
        return accountIds;
    }

    @Override
    public Account getAccountById(Integer accountId) {

        Account account = null;
        String sql = "SELECT account_id, user_id, account_type, balance " +
                "FROM account " +
                "WHERE account_id = " + accountId + ";";

        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            if (results.next()) {
                account = mapRowToAccount(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return account;
    }

    @Override
    public BigDecimal getBalanceByUsername(String username) {
        String sql = "SELECT a.balance FROM account a " + "WHERE u.username = ?;";
        try {
            return jdbcTemplate.queryForObject(sql, BigDecimal.class, username);

        } catch (Exception e){
            throw new DaoException("Error retrieving balance by username", e);
        }
    }

    private Account mapRowToAccount(SqlRowSet rs) {
        Account account = new Account();
        account.setAccountId(rs.getInt("account_id"));
        account.setUserId(rs.getInt("user_id"));
        account.setAccountType(rs.getString("account_type"));
        account.setBalance(rs.getBigDecimal("balance"));
        return account;
    }
}
