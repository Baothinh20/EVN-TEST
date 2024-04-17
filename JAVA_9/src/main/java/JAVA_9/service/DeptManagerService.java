package JAVA_9.service;

import JAVA_9.entity.DeptEmp;
import JAVA_9.entity.DeptManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptManagerService {
    public List<DeptManager> getAllDeptManager();
    public DeptManager createDeptManager(DeptManager deptManager);
    public DeptManager updateDeptManager(DeptManager deptManager);
    public void deleteDeptManager();
}
