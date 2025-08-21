package com.techelevator.tenmo.controller;


import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.model.Account;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("isAuthenticated")

public class AccountController {
    private final AccountDao accountDao;

    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @RequestMapping(path = "/account/balance", method = RequestMethod.GET)
    public BigDecimal getBalance(Principal principal) {
        String username = principal.getName();
        return accountDao.getBalanceByUsername(username);
    }

    @RequestMapping(path = "/account", method = RequestMethod.GET)
    public List<Integer> allAccounts(){
        return accountDao.allAccounts();
    }

}
