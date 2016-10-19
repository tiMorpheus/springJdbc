package github.tiMorpheus.customer.bo.impl;

import github.tiMorpheus.customer.bo.CustomerBo;
import github.tiMorpheus.customer.dao.CustomerDao;
import github.tiMorpheus.customer.model.Customer;

import java.util.List;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public void addCustomer(Customer customer) {
        customerDao.addCustomer(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerDao.findAllCustomer();
    }
}
