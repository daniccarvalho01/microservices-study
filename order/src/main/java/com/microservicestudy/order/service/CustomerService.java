package com.microservicestudy.order.service;

import com.microservicestudy.order.client.CustomerAPI;
import com.microservicestudy.order.domain.response.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerAPI customerAPI;

    public CustomerResponse getCustomer(Long customerId) {

        try {
            CustomerResponse customerResponse = customerAPI.findCustomer(customerId);
            customerResponse.setId(customerId);
            return customerResponse;

        } catch (Exception ex) {
            log.warn("getCustomer, Erro ao buscar o cliente, customerId={}", customerId);
            return null;
        }
    }
}
