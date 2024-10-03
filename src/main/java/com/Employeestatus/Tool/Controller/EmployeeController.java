package com.Employeestatus.Tool.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.Employeestatus.Tool.Model.Employee;
import com.Employeestatus.Tool.Service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/employee")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    
    @PostMapping("/add")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        try {
            Employee savedEmployee = employeeService.saveEmployee(employee);
            return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error saving employee", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/employeestatus")
    public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(value = "Status", required = false) String Status) {
        try {
            List<Employee> employees = employeeService.getAllEmployees(Status);
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error retrieving employees", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/employeesstatus/{Empid}")
    public ResponseEntity<Employee> getEmployeeByEmpid(@PathVariable Long Empid) {
        try {
            Employee employee = employeeService.getEmployeeByEmpid(Empid);
            if (employee != null) {
                return new ResponseEntity<>(employee, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error("Error retrieving employee with id " + Empid, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @PutMapping("/employeestatus/{Empid}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long Empid, @RequestBody Employee employee) {
        try {
            Employee updatedEmployee = employeeService.updateEmployee(Empid, employee);
            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
        } catch (RuntimeException e) {
            logger.error("Error updating employee with id " + Empid, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("Unexpected error updating employee with id " + Empid, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    
    @DeleteMapping("/employeestatus/{Empid}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long Empid) {
        try {
            employeeService.deleteEmployee(Empid);
            return ResponseEntity.ok("Deleted successfully");
        } catch (RuntimeException e) {
            logger.error("Error deleting employee with id " + Empid, e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error deleting employee with id " + Empid, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected error occurred");
        }
    }
}
