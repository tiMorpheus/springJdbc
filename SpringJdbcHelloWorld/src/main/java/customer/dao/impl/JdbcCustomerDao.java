package customer.dao.impl;

import customer.dao.CustomerDao;
import customer.model.Customer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCustomerDao /*extends JdbcDaoSupport*/ implements CustomerDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insert(Customer customer) {

        String sql = "INSERT INTO customer " +
                "(cust_id, name, age) VALUES (?, ?, ?)";

        jdbcTemplate = new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql, new Object[]{ customer.getCustId(),
        customer.getName(), customer.getAge()});


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

        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custId);
            Customer customer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                customer = new Customer(
                        rs.getInt("CUST_ID"),
                        rs.getString("NAME"),
                        rs.getInt("Age")
                );
            }
            rs.close();
            ps.close();
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
