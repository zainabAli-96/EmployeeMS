package com.ZainabKhamis.EmployeeManagementSystem.Repository;

import com.ZainabKhamis.EmployeeManagementSystem.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findBySalaryBetween(Double fromSalary, Double toSalary);

    List<Employee> findBySalaryGreaterThanEqual(Double fromSalary);

    List<Employee> findBySalaryLessThanEqual(Double toSalary);

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseAndSalaryBetween(String name, String name1, Double fromSalary, Double toSalary);

    List<Employee> findByFirstNameContaininIgnoreCasegOrLastNameContainingIgnoreCaseAndSalaryGreaterThanEqual(String name, String name1, Double fromSalary);

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseAndSalaryLessThanEqual(String name, String name1, Double toSalary);

    List<Employee> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String name1);
}
