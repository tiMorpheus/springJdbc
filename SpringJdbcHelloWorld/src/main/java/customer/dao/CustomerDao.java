package customer.dao;

import customer.model.Customer;
import java.util.*;

public interface CustomerDao {

    void insert(Customer customer);

    Customer findByCustomerId(int custId);

    int findTotalCustomer();

    Customer findByCustomerId2(int custid);

    List<Customer> findAll();

    List<Customer> findAll2();

    String findCustomerNameById(int i);
}
