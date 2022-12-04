package com.example.csc174project.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.csc174project.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {
    /**
     * This method is in charge of inserting the value into the database. It receives a customer as a parameter, and
     * inserts the name.
     *
     * @param customer entity
     * @return String
     */
    public String insertCustomer(Customer customer) {

        String url = "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00";
        String username = "urcyphloccxygf";
        String password = "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO customer (first) VALUES (?)");
            statement.setString(1, customer.getFirstName());
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Query insertion Successful";
    }

    /**
     * This method returns a list of all the customers in the customer table.
     * @return
     */
    public List<Customer> customerTable() {
        List<Customer> customers = new ArrayList<>();

        String url = "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00";
        String username = "urcyphloccxygf";
        String password = "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351";

        try {
            // connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // executes the query to retrieve the customers from the table using a result set.
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from customer");

            // iterate over the result set. Creates a customer object, and adds it to the list.
            while (result.next()) {
                Customer customer = new Customer();

                customer.setCustomerID(result.getString(1));
                customer.setFirstName(result.getString(2));
                customer.setLastName(result.getString(3));
                customer.setState(result.getString(4));
                customer.setCity(result.getString(5));
                customer.setZipCode(result.getString(6));
                customer.setStreet(result.getString(7));

                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
