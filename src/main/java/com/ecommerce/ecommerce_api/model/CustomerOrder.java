package com.ecommerce.ecommerce_api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Create a table named customer_order.
public class CustomerOrder {

    @Id//primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private java.time.LocalDate orderDate;
    private String customerName;

    @ManyToMany // create a third, separate table for me named order_products
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"), // create a column named order_id that will be a foreign key pointing to.
            inverseJoinColumns = @JoinColumn(name = "product_id")// creates a column named product_id that will be a foreign key pointing to the product table
    )
    private List<Product> products;

}
