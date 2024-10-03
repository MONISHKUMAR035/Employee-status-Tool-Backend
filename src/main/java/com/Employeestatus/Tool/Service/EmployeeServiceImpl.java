package com.Employeestatus.Tool.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Employeestatus.Tool.Model.Employee;
import com.Employeestatus.Tool.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(String Status) {
        if (Status != null) {
            return employeeRepository.findByStatus(Status);  
        }
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmpid(Long Empid) {  
        return employeeRepository.findById(Empid).orElse(null);
    }

    @Override
    public void deleteEmployee(Long Empid) {  
        Optional<Employee> optionalEmployee = employeeRepository.findById(Empid);
        if (optionalEmployee.isPresent()) {
            employeeRepository.delete(optionalEmployee.get());
        } else {
            throw new RuntimeException("Employee not found with id: " + Empid);
        }
    }

    @Override
    public Employee updateEmployee(Long Empid, Employee employee) {  
        Optional<Employee> optionalEmployee = employeeRepository.findById(Empid);
        if (optionalEmployee.isPresent()) {
            Employee oldEmployee = optionalEmployee.get();
            employee.setEmpid(oldEmployee.getEmpid());  
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + Empid);
        }
    }
}
