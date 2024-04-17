package JAVA_9.service.impl;

import JAVA_9.entity.Department;
import JAVA_9.entity.DeptEmp;
import JAVA_9.repository.DeptEmpRepository;
import JAVA_9.service.DeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptEmpServiceImpl implements DeptEmpService {

    @Autowired
    private DeptEmpRepository deptEmpRepository;

    @Override
    public List<DeptEmp> getAllDeptEmp() {
        return deptEmpRepository.findAll();
    }

    @Override
    public DeptEmp createDeptEmp(DeptEmp deptEmp) {
        return deptEmpRepository.save(deptEmp);
    }

    @Override
    public DeptEmp updateDeptEmp(DeptEmp deptEmp) {
        return deptEmpRepository.save(deptEmp);
    }

    @Override
    public void deleteDeptEmp() {

    }

    @Override
    public void changeEmpDept(int empNo, String deptNo) {
        deptEmpRepository.changeEmpDept(empNo, deptNo);
    }
}
