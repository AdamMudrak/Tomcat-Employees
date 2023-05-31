package org.example.app.daos;

import org.example.app.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private final String jdbcURL;
    private final String jdbcUsername;
    private final String jdbcPass;
    private Connection jdbcConn;

    public EmployeeDAO(String jdbcURL, String jdbcUsername, String jdbcPass) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPass = jdbcPass;
    }

    protected void connect() throws SQLException {
        if (jdbcConn == null || jdbcConn.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException cnfe) {
                throw new SQLException(cnfe);
            }
            jdbcConn = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPass);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConn != null && !jdbcConn.isClosed()) {
            jdbcConn.close();
        }
    }

    public void createEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees (first_name, last_name, position, phone) VALUES (?, ?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConn.prepareStatement(sql);
        statement.setString(1, employee.getfirst_name());
        statement.setString(2, employee.getlast_name());
        statement.setString(3, employee.getPosition());
        statement.setString(4, employee.getPhone());

        statement.executeUpdate();
        statement.close();
        disconnect();
    }

    public List<Employee> readEmployees() throws SQLException {
        List<Employee> employeesList = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        connect();

        Statement statement = jdbcConn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String position = resultSet.getString("position");
            String phone = resultSet.getString("phone");

            Employee employee = new Employee(id, first_name, last_name, position, phone);
            employeesList.add(employee);
        }
        resultSet.close();
        statement.close();
        disconnect();
        return employeesList;
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        String sql = "DELETE FROM employees where id = ?";

        connect();

        PreparedStatement statement = jdbcConn.prepareStatement(sql);
        statement.setInt(1, employee.getId());

        statement.executeUpdate();
        statement.close();
        disconnect();
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE employees SET first_name = ?, last_name = ?, position = ?, phone = ? WHERE id = ?";
        connect();

        PreparedStatement statement = jdbcConn.prepareStatement(sql);
        statement.setString(1, employee.getfirst_name());
        statement.setString(2, employee.getlast_name());
        statement.setString(3, employee.getPosition());
        statement.setString(4, employee.getPhone());
        statement.setInt(5, employee.getId());

        statement.executeUpdate();
        statement.close();
        disconnect();
    }

    public Employee getEmployee(int id) throws SQLException {
        Employee employee = null;
        String sql = "SELECT * FROM employees WHERE id = ?";

        connect();

        PreparedStatement statement = jdbcConn.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String position = resultSet.getString("position");
            String phone = resultSet.getString("phone");

            employee = new Employee(id, first_name, last_name, position, phone);
        }

        resultSet.close();
        statement.close();
        return employee;
    }
}
