package com.ZainabKhamis.EmployeeManagementSystem.ServiceImpl;

import com.ZainabKhamis.EmployeeManagementSystem.Entity.Employee;
import com.ZainabKhamis.EmployeeManagementSystem.Exceptions.EmployeeNotFoundException;
import com.ZainabKhamis.EmployeeManagementSystem.Repository.EmployeeRepository;
import com.ZainabKhamis.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    @Override
    public Employee findEmployeeById(int id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new
            EmployeeNotFoundException("Employee not found with ID: " + id);
        }
    }

    @Override
    public List<Employee> findByCriteria(String name, Double fromSalary, Double toSalary) {
        List<Employee> employees = new ArrayList<>();

        if (name != null && !name.isEmpty()) {
            if (fromSalary != null && toSalary != null) {
                employees = employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseAndSalaryBetween(name, name, fromSalary, toSalary);

                employees = employees.stream()
                .filter(employee -> employee.getSalary() >= fromSalary && employee.getSalary() <= toSalary)
                .collect(Collectors.toList());
            } else if (fromSalary != null) {
                employees =  employeeRepository.findByFirstNameContaininIgnoreCasegOrLastNameContainingIgnoreCaseAndSalaryGreaterThanEqual(name, name, fromSalary);
            } else if (toSalary != null) {
                employees =  employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseAndSalaryLessThanEqual(name, name, toSalary);
            } else {
                employees =  employeeRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(name, name);
            }
        } else {
            if (fromSalary != null && toSalary != null) {
                employees =  employeeRepository.findBySalaryBetween(fromSalary, toSalary);
            } else if (fromSalary != null) {
                employees =  employeeRepository.findBySalaryGreaterThanEqual(fromSalary);
            } else if (toSalary != null) {
                employees =  employeeRepository.findBySalaryLessThanEqual(toSalary);
            } else {
                employees =  employeeRepository.findAll();
            }
        }

//        employees = employees.stream()
//                .filter(employee -> employee.getSalary() >= fromSalary && employee.getSalary() <= toSalary)
//                .collect(Collectors.toList());

        if(!employees.isEmpty()){
            return employees;

        }
        throw new EmployeeNotFoundException("No Employee found with the given criteria");

    }


    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> emps = new ArrayList<>();
        emps=employeeRepository.findAll();
        if(!emps.isEmpty()){
            return emps;
        }
        throw new EmployeeNotFoundException("There is no Employee added to the system");

    }


}
