package com.ZainabKhamis.EmployeeManagementSystem.Controller;

import com.ZainabKhamis.EmployeeManagementSystem.Dto.addEmployeeDto;
import com.ZainabKhamis.EmployeeManagementSystem.Entity.Employee;
import com.ZainabKhamis.EmployeeManagementSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<addEmployeeDto> createEmployee(@RequestBody Employee employee) {
         employeeService.addEmployee(employee);
         addEmployeeDto empDto = new addEmployeeDto();
         empDto.setId(employee.getId());
         return ResponseEntity.ok(empDto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees() {
      List<Employee> employees= employeeService.getAllEmployees();
        if (employees == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable int id) {
       Employee employee= employeeService.findEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam(required = false) String name,
                                                          @RequestParam(required = false) Double fromSalary,
                                                          @RequestParam(required = false) Double toSalary) {
        List<Employee> employees = employeeService.findByCriteria(name, fromSalary, toSalary);
        if(employees.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }
}