package com.bankweb.account.controller;


import com.bankweb.account.service.impelmentation.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AccountController {


    @Autowired
    AccountServiceImpl accountService;
}
