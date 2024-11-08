package com.example.paymenth.poc.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/paypal")
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {


}
