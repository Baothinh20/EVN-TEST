package JAVA_9.controller;

import JAVA_9.service.DeptManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptManagerController {
    @Autowired
    private DeptManagerService deptManagerService;
}
