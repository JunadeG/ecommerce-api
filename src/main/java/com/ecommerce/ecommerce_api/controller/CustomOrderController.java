package com.ecommerce.ecommerce_api.controller;


import com.ecommerce.ecommerce_api.dto.OrderRequestDTO;
import com.ecommerce.ecommerce_api.model.CustomerOrder;
import com.ecommerce.ecommerce_api.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/orders")
public class CustomOrderController {

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping
    public List<CustomerOrder> getAllOrders(){
       return customerOrderService.getAllOrders();
    }

    @PostMapping
    public ResponseEntity<CustomerOrder> createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
        CustomerOrder createdOrder = customerOrderService.createOrder(
                orderRequestDTO.getCustomerName(),
                orderRequestDTO.getProductIds());
                return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);

    }

}
