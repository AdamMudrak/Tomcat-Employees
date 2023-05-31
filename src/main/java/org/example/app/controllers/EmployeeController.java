package org.example.app.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.app.daos.EmployeeDAO;
import org.example.app.entities.Employee;
import org.example.app.utils.Constants;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController extends HttpServlet {

    private final EmployeeDAO employeeDAO = new EmployeeDAO(Constants.DB_URL,
            Constants.DB_USER, Constants.DB_PASS);

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new" -> showNewForm(request, response);
                case "/insert" -> insertEmployee(request, response);
                case "/delete" -> deleteEmployee(request, response);
                case "/edit" -> showEditForm(request, response);
                case "/update" -> updateEmployee(request, response);
                default -> listEmployees(request, response);
            }
        } catch (SQLException sqle) {
            throw new ServletException(sqle);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Employee> employeeList = employeeDAO.readEmployees();
        request.setAttribute("listEmployees", employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee_list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee_form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeDAO.getEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee_form.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String position = request.getParameter("position");
        String phone = request.getParameter("phone");

        Employee newEmployee = new Employee(first_name, last_name, position, phone);
        employeeDAO.createEmployee(newEmployee);
        response.sendRedirect("list");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String position = request.getParameter("position");
        String phone = request.getParameter("phone");

        Employee employee = new Employee(id, first_name, last_name, position, phone);
        employeeDAO.updateEmployee(employee);
        response.sendRedirect("list");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Employee employee = new Employee(id);
        employeeDAO.deleteEmployee(employee);
        response.sendRedirect("list");
    }
}
