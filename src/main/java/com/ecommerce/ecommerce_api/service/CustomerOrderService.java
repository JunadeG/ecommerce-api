package com.ecommerce.ecommerce_api.service;

import com.ecommerce.ecommerce_api.model.CustomerOrder;
import com.ecommerce.ecommerce_api.model.Product;
import com.ecommerce.ecommerce_api.repository.CustomerOrderRepository;
import com.ecommerce.ecommerce_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
public class CustomerOrderService {
    @Autowired
    private CustomerOrderRepository  customerOrderRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<CustomerOrder> getAllOrders(){
        return customerOrderRepository.findAll();
    }

    public CustomerOrder createOrder(String customerName, List<Long> productIds){
        List<Product> productsForOrder = productRepository.findAllById(productIds);

        // A quick safety check: what if the user ordered products that don't exist?
        // If the list of found products is empty, we should probably throw an error.
        if(productsForOrder.isEmpty()){
            throw new RuntimeException("Could not create order: No valid products found for the given IDs");
        }

        CustomerOrder newOrder = new CustomerOrder();

        newOrder.setCustomerName(customerName);
        newOrder.setOrderDate(LocalDate.now());
        newOrder.setProducts(productsForOrder);


        return customerOrderRepository.save(newOrder);
    }

}
