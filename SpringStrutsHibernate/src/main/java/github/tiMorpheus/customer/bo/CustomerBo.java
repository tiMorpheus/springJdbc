package github.tiMorpheus.customer.bo;

import github.tiMorpheus.customer.model.Customer;

import java.util.*;
public interface CustomerBo {

    void addCustomer(Customer customer);

    List<Customer> findAllCustomer();
}
