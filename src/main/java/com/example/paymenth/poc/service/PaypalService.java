package com.example.paymenth.poc.service;

import com.example.paymenth.poc.model.PaymentOrder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface PaypalService {

    PaymentOrder createPayment(BigDecimal fee);
}
