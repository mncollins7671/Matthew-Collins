package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Account{
    private int accountId;
    private int userId;
    private String accountType;
    private BigDecimal balance;

   public Account() {}

    public Account(int accountId, int userId, String accountType, BigDecimal balance) {
        this.accountId = accountId;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getUserId() {
        return userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
