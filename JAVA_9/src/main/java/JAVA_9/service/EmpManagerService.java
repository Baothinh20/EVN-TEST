package JAVA_9.service;

import JAVA_9.dto.EmpTitleSalary;
import org.springframework.stereotype.Service;

@Service
public interface EmpManagerService {
    public void setupNewEmployees(EmpTitleSalary empTitleSalary);
    public  void changeDept(int empNo, String deptNo);
}
