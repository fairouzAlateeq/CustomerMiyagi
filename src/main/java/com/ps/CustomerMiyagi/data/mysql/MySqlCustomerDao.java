package com.ps.CustomerMiyagi.data.mysql;

import com.ps.CustomerMiyagi.data.CustomerDao;
import com.ps.CustomerMiyagi.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MySqlCustomerDao implements CustomerDao {

    private DataSource dataSource;

    @Autowired
    public MySqlCustomerDao(DataSource datasource) {
        this.dataSource = datasource;
    }


    @Override
    public List<Customer> findAll() {
        //System.out.println(dataSource);
        String query = "Select * from customer;";
        List<Customer> customers = new ArrayList<>();
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {

            while (resultSet.next()) {
                Customer customer = mapCustomer(resultSet);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public Customer findOneCustomer(int id) {
        String query = "Select * from customer where customer_id = ?";
        Customer customer = null;
        try (
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            // instead of Resultset we need to set the id; so now nested try
            preparedStatement.setInt(1, id);
            try (
                    ResultSet resultSet = preparedStatement.executeQuery();

            ) {
                //cause we only have one
                if (resultSet.next()) {
                    customer = mapCustomer(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        String query = "Insert into customer('name, 'phone') values(?,?)";
        try (
                Connection connection = this.dataSource.getConnection();
                // we request the generated keys
                PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getPhone());
            // to make sure it excuted
            int rows = preparedStatement.executeUpdate();
            if (rows > 0) {
                try (
                        ResultSet resultSet = preparedStatement.getGeneratedKeys();
                        ) {

                    if(resultSet.next()){
                        customer.setCustomerId(resultSet.getInt(1));
                        return customer;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return null;
}

@Override
public void updateCustomer(int id, Customer customer){
        String query = "update customer set name = ?, phone = ? where customer_id = ?";
    try(
            Connection connection = this.dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
    ) {
        preparedStatement.setString(1, customer.getName());
        preparedStatement.setString(2, customer.getPhone());
        preparedStatement.setInt(3, id);

        preparedStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    @Override
    public void deleteACustomer(int id){
        String query = "delete from customer where customer_id = ?";
        try(
                Connection connection = this.dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }


    //mapping a customer

    private Customer mapCustomer(ResultSet resultSet) throws SQLException {
        int customerId = resultSet.getInt("customer_id");
        String name = resultSet.getString("name");
        String phone = resultSet.getString("phone");

        return new Customer(customerId, name, phone);

    }

}