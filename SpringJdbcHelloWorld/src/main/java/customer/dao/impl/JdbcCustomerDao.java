package customer.dao.impl;

import customer.dao.CustomerDao;
import customer.model.Customer;
import customer.model.CustomerRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.*;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDao extends JdbcDaoSupport implements CustomerDao {

    public void insert(Customer customer) {

        String sql = "INSERT INTO customer " +
                "(cust_id, name, age) VALUES (?, ?, ?)";

        getJdbcTemplate().update(sql, new Object[]{customer.getCustId(),
            customer.getName(), customer.getAge()
        });


/*        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[]{ customer.getCustId(),
        customer.getName(), customer.getAge()});*/


/*        Connection connection = null;

        try{
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customer.getCustId());
            ps.setString(2, customer.getName());
            ps.setInt(3, customer.getAge());
            ps.executeUpdate();
            ps.close();

        }catch (SQLException e){
            throw new RuntimeException(e);
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }*/
    }



    public Customer findByCustomerId(int custId) {

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";


        Customer customer = (Customer)getJdbcTemplate().queryForObject(
                sql, new Object[] { custId }, new CustomerRowMapper());

        return customer;

    }

    public Customer findByCustomerId2(int custId){

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

        Customer customer = (Customer)getJdbcTemplate().queryForObject(
                sql, new Object[] { custId },
                new BeanPropertyRowMapper(Customer.class));

        return customer;
    }

    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers = new ArrayList<Customer>();

        List<Map> rows = getJdbcTemplate().queryForList(sql);
        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setCustId((Integer)(row.get("CUST_ID")));
            customer.setName((String)row.get("NAME"));
            customer.setAge((Integer)row.get("AGE"));
            customers.add(customer);
        }

        return customers;
    }

    public String findCustomerNameById(int custId){

        String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";

        String name = (String) getJdbcTemplate().queryForObject(
                sql, new Object[] { custId }, String.class);

        return name;

    }

    public int findTotalCustomer(){

        String sql = "SELECT COUNT(*) FROM CUSTOMER";

        int total = getJdbcTemplate().queryForInt(sql);

        return total;
    }

    //query mutiple rows with BeanPropertyRowMapper (Customer.class)
    public List<Customer> findAll2(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers  = getJdbcTemplate().query(sql,
                new BeanPropertyRowMapper(Customer.class));

        return customers;
    }

}
