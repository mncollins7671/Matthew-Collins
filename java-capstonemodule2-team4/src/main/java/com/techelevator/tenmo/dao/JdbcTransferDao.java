package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;




@Component
public class JdbcTransferDao implements TransferDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
@Override
    public Transfer transferFunds(String transferType, int accountTo, int accountFrom, BigDecimal amount, String description) {
        BigDecimal fromBalance = getBalance(accountFrom);
        Transfer newTransfer = new Transfer();
        if (fromBalance.compareTo(amount) <= 0) {
            throw new IllegalArgumentException("Insufficient Funds :( ");
        }
        if (accountFrom == accountTo){
            throw new IllegalArgumentException("Error: cannot transfer funds to self :( ");
        }

        updateBalance(accountFrom, fromBalance.subtract(amount));
        BigDecimal toBalance = getBalance(accountTo);
        updateBalance(accountTo, toBalance.add(amount));
        String sql = "INSERT INTO transfer (transfer_type, transfer_status, account_from, account_to, amount, description, status) VALUES (?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING transfer_id;";
        Integer newTransactionId = jdbcTemplate.queryForObject(sql, Integer.class, "Send", "Approved", accountFrom, accountTo, amount, "description");

        return newTransfer;
    }

    private void updateBalance(int accountId, BigDecimal newBalance) {
        String sql = "UPDATE account SET balance = ? WHERE account_id = ?";
        jdbcTemplate.update(sql, newBalance, accountId);
    }

    private BigDecimal getBalance(int accountId) {
        String sql = "SELECT balance FROM account WHERE account_id = ?;";
    return jdbcTemplate.queryForObject(sql, BigDecimal.class, accountId);
    }


    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTransferId(rs.getInt("transfer_id"));
        transfer.setTransferType(rs.getString("transfer_type"));
        transfer.setTransferStatus(rs.getString("transfer_status"));
        transfer.setAccountFrom(rs.getInt("account_from"));
        transfer.setAccountTo(rs.getInt("account_to"));
        transfer.setAmount(rs.getBigDecimal("amount"));
        transfer.setDescription(rs.getString("description"));

        return transfer;
    }

}
