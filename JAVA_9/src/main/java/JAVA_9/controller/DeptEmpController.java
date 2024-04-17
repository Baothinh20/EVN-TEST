package JAVA_9.controller;

import JAVA_9.service.DeptEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptEmpController {
    @Autowired
    private DeptEmpService deptEmpService;
}
