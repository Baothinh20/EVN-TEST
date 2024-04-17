package JAVA_9.service.impl;

import JAVA_9.entity.DeptManager;
import JAVA_9.repository.DeptManagerRepository;
import JAVA_9.service.DeptManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptManagerServiceImpl implements DeptManagerService {

    @Autowired
    private DeptManagerRepository deptManagerRepository;

    @Override
    public List<DeptManager> getAllDeptManager() {
        return deptManagerRepository.findAll();
    }

    @Override
    public DeptManager createDeptManager(DeptManager deptManager) {
        return deptManagerRepository.save(deptManager);
    }

    @Override
    public DeptManager updateDeptManager(DeptManager deptManager) {
        return deptManagerRepository.save(deptManager);
    }

    @Override
    public void deleteDeptManager() {

    }
}
