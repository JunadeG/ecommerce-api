package com.ecommerce.ecommerce_api.dto;

import lombok.Data;

import java.util.List;

// the dto class.
@Data
public class OrderRequestDTO {
    private String customerName;
    private List<Long> productIds;

}
