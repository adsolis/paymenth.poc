package com.example.paymenth.poc.service;

import com.example.paymenth.poc.model.PaymentOrder;
import com.paypal.core.PayPalHttpClient;
import com.paypal.http.HttpResponse;
import com.paypal.orders.*;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
public class PaypalServiceImpl implements PaypalService {

    private PayPalHttpClient payPalHttpClient;
    @Override
    public PaymentOrder createPayment(BigDecimal fee) {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");
        AmountWithBreakdown amountWithBreakdown = new AmountWithBreakdown().currencyCode("USD").
                value(fee.toString());

        PurchaseUnitRequest purchaseUnitRequest =
                new PurchaseUnitRequest().amountWithBreakdown(amountWithBreakdown);

        orderRequest.purchaseUnits(List.of(purchaseUnitRequest));
        ApplicationContext applicationContext = new ApplicationContext().
                returnUrl("https://localhost:4200/capture").
                cancelUrl("https://localhost:4200/cancel");

        orderRequest.applicationContext(applicationContext);

        OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest().requestBody(orderRequest);

         try {
             HttpResponse<Order> orderHttpResponse = payPalHttpClient.execute(ordersCreateRequest);
             Order order = orderHttpResponse.result();
         } catch (Exception e) {

         }

        return null;
    }
}
