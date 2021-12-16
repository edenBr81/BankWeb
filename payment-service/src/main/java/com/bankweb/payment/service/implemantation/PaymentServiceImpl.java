package com.bankweb.payment.service.implemantation;


import com.bankweb.payment.repository.PaymentRepository;
import com.bankweb.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
}
