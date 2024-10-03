package com.Employeestatus.Tool.Repository;

import com.Employeestatus.Tool.Model.Employee;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {  

	List<Employee> findByStatus(String Status);
}

