package JAVA_9.service.impl;

import JAVA_9.dto.EmployeesDTO;
import JAVA_9.entity.Employees;
import JAVA_9.repository.EmployeesRepository;
import JAVA_9.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees createEmployee(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public Employees updateEmployee(Employees employees) {
        return employeesRepository.save(employees);
    }

    @Override
    public void deleteEmployee() {

    }

    @Override
    public Employees findByEmpNo(int empNo) {
        return employeesRepository.findByEmpNo(empNo);
    }
    @Override
    public  List<EmployeesDTO> findByEmpNoDTO (Integer empNo){
        return employeesRepository.findByEmpNoDTO(empNo);
    }

    @Override
    public List<Employees> findAll(Specification<Employees> spec) {
        return employeesRepository.findAll(spec);
    }

}
