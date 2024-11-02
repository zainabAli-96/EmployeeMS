package com.ZainabKhamis.EmployeeManagementSystem.Service;

import com.ZainabKhamis.EmployeeManagementSystem.Entity.Employee;
import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    Employee findEmployeeById(int id);

    List<Employee> findByCriteria(String name, Double fromSalary, Double toSalary);

    List<Employee> getAllEmployees();
}
