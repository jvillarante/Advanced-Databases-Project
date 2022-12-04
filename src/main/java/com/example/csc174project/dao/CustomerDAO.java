package com.example.csc174project.dao;

import java.sql.*;
import java.util.UUID;

import com.example.csc174project.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {
    /**
     * This method will be in charge of opening a connection to our database. Insert values in the corresponding
     * fields. Once the values have been inserted the connection will be closed and a message will be returned
     * to let the user know that the insertion was successful.
     *
     * @param customer entity
     * @return String
     */
    public String insertCustomer(Customer customer) {

        String url = "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00";
        String username = "urcyphloccxygf";
        String password = "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351";
        String query = "SELECT * FROM store";

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

    public String selectCustomer(String selectCustomer) {
        //Credentials of our database ?
        String url = "jdbc:postgresql://ec2-3-92-98-129.compute-1.amazonaws.com:5432/d2kcc4it2iou00";
        String username = "urcyphloccxygf";
        String password = "16e062b8cc6601f501d1b62aee13c758540331c093d7074f424bc687b6bf5351";
        String query = "SELECT * FROM store";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = conn.prepareStatement("SELECT first  FROM customer WHERE (first = ?)");
            statement.setString(1, selectCustomer);
            var customers = statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Selection successful";
    }
}
