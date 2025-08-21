package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

public interface TransferDao {

    Transfer transferFunds(String transferType, int accountTo, int accountFrom, BigDecimal amount, String description);
}
