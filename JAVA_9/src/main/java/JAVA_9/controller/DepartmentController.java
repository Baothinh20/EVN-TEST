package JAVA_9.controller;

import JAVA_9.entity.Department;
import JAVA_9.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/getAllDepartment")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
}
