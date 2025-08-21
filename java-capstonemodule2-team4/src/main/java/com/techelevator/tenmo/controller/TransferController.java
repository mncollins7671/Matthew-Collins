package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.security.Principal;

@RestController
@RequestMapping("/transfer")

public class TransferController {

private final TransferDao transferDao;

    public TransferController(TransferDao transferDao) {
        this.transferDao = transferDao;
    }


    @PostMapping("/send")
    public Transfer transferFunds(@RequestBody Transfer transferRequest, Principal principal){
        return transferDao.transferFunds(
                transferRequest.getTransferType(),
                transferRequest.getAccountTo(),
                transferRequest.getAccountFrom(),
                transferRequest.getAmount(),
                transferRequest.getDescription()
        );
    }



}
