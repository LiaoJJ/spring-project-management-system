package com.example.pma.dao;

import com.example.pma.dto.EmployeeProject;
import com.example.pma.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value = "select e.first_name as firstName, e.last_name as lastName, count(pe.employee_id) as projectCount " +
            "from employee e left join project_employee pe on e.employee_id = pe.employee_id " +
            "group by (e.employee_id) " +
            "order by 3 desc ")
    public List<EmployeeProject> employeeProjects();
}
