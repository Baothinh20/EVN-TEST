package JAVA_9.service;

import JAVA_9.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {
    public List<Department> getAllDepartment();
    public Department createDepartment(Department department);
    public Department updateDepartment(Department department);
    public void deleteDepartment();

    public Department findByDeptNo(String deptNo);
}
