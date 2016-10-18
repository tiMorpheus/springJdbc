package customer.dao;

import customer.model.Customer;

public interface CustomerDao {

    void insert(Customer customer);

    Customer findByCustomerId(int custId);
}
