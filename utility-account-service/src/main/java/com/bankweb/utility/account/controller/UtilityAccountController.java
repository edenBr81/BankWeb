package com.bankweb.utility.account.controller;


import com.bankweb.utility.account.service.implementation.UtilityAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utilities")
public class UtilityAccountController {

    @Autowired
    UtilityAccountService utilityAccountService;
}
