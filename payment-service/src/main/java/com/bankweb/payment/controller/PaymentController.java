package com.bankweb.payment.controller;


import com.bankweb.payment.service.PaymentService;
import com.bankweb.payment.service.implemantation.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;
}
