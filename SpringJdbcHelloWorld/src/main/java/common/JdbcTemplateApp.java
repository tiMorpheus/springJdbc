package common;

import customer.dao.CustomerDao;
import customer.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;

public class JdbcTemplateApp {
    public static void main( String[] args )
    {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("SpringModule.xml");

        CustomerDao customerDAO = (CustomerDao) context.getBean("customerDao");

        Customer customerA = customerDAO.findByCustomerId(1);
        System.out.println("Customer A : " + customerA);

        Customer customerB = customerDAO.findByCustomerId2(1);
        System.out.println("Customer B : " + customerB);

        List<Customer> customerAs = customerDAO.findAll();
        for(Customer cust: customerAs){
            System.out.println("Customer As : " + customerAs);
        }

        List<Customer> customerBs = customerDAO.findAll2();
        for(Customer cust: customerBs){
            System.out.println("Customer Bs : " + customerBs);
        }

        String customerName = customerDAO.findCustomerNameById(1);
        System.out.println("Customer Name : " + customerName);

        int total = customerDAO.findTotalCustomer();
        System.out.println("Total : " + total);

    }
}
