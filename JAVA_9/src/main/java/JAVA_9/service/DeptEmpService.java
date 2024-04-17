package JAVA_9.service;

import JAVA_9.entity.Department;
import JAVA_9.entity.DeptEmp;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptEmpService {
    public List<DeptEmp> getAllDeptEmp();
    public DeptEmp createDeptEmp(DeptEmp deptEmp);
    public DeptEmp updateDeptEmp(DeptEmp deptEmp);
    public void deleteDeptEmp();

    public void changeEmpDept(int empNo, String deptNo);
}
