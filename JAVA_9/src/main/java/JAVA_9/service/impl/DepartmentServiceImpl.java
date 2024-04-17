package JAVA_9.service.impl;

import JAVA_9.entity.Department;
import JAVA_9.repository.DepartmentRepository;
import JAVA_9.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment() {
    }

    @Override
    public Department findByDeptNo(String deptNo) {
        return departmentRepository.findByDeptNo(deptNo);
    }
}
