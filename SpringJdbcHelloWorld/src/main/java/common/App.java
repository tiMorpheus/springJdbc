package common;

import customer.dao.CustomerDao;
import customer.model.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context;
        context = new ClassPathXmlApplicationContext("SpringModule.xml");

        CustomerDao customerDAO = (CustomerDao) context.getBean("customerDao");
        Customer customer = new Customer(2, "Tima", 21);
        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(2);
        System.out.println(customer1);


    }
}
