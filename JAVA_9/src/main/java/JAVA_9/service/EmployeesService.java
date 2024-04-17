package JAVA_9.service;

import JAVA_9.dto.EmployeesDTO;
import JAVA_9.entity.Employees;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {
    //CRUD
    public List<Employees> getAllEmployees();
    public Employees createEmployee(Employees employees);
    public Employees updateEmployee(Employees employees);
    public void deleteEmployee();
    public Employees findByEmpNo(int empNo);
    public  List<EmployeesDTO> findByEmpNoDTO (Integer empNo);
    public  List<Employees> findAll(Specification<Employees> spec);
}
