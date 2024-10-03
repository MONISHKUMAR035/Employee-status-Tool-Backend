package com.Employeestatus.Tool.Service;

import java.util.List;
import com.Employeestatus.Tool.Model.Employee;

public interface EmployeeService {
    
    public Employee saveEmployee(Employee employee);
    
    public List<Employee> getAllEmployees(String Status);  
    
    public Employee getEmployeeByEmpid(Long Empid);  
    
    public void deleteEmployee(Long Empid);  
    
    public Employee updateEmployee(Long Empid, Employee employee);  
}
