package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {
    BigDecimal getBalanceByUserId(int userId);

    Account getAccountById(Integer accountId);

    BigDecimal getBalanceByUsername(String username);

    List<Integer> allAccounts();
}
