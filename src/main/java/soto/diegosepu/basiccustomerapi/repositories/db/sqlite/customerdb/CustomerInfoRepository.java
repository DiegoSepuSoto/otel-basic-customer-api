package soto.diegosepu.basiccustomerapi.repositories.db.sqlite.customerdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import soto.diegosepu.basiccustomerapi.models.Customer;
import soto.diegosepu.basiccustomerapi.repositories.CustomerInfoI;
import soto.diegosepu.basiccustomerapi.controllers.http.customer.CustomerController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class CustomerInfoRepository implements CustomerInfoI {
    private final String databaseURL = "jdbc:sqlite:customers.db";
    private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    public void connect() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(databaseURL);

            logger.info("connection to SQLite has been established");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public void prepareTables() {
        String sql = "CREATE TABLE IF NOT EXISTS customers (customerID text NOT NULL, name text NOT NULL, lastName text NOT NULL);";

        try (Connection conn = DriverManager.getConnection(databaseURL);
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

            logger.info("tables ready in database");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    public void prepareData() {
        String sql = "INSERT INTO customers(customerID, name, lastName) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(databaseURL); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "abc123");
            pstmt.setString(2, "John");
            pstmt.setString(3, "Doe");

            pstmt.executeUpdate();

            logger.info("data ready in database");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public Customer GetCustomerInfo(String customerID) {
        String sql = "SELECT customerID, name, lastName FROM customers";
        Customer customer = null;


        try (Connection conn = DriverManager.getConnection(databaseURL);
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)) {

            Thread.sleep(500);

            while (rs.next()) {
                String name = rs.getString("name");
                String lastName = rs.getString("lastName");

                customer = new Customer(name, lastName, customerID);
            }

            return customer;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.error("error on delay: {}", e.toString());
        }

        return null;
    }
}
