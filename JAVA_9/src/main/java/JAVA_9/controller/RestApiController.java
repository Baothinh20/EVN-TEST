package JAVA_9.controller;

import JAVA_9.dto.EmpTitleSalary;
import JAVA_9.service.EmpManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @Autowired
    private EmpManagerService empManagerService;
    @PostMapping("/setupNewEmployees")
    public void setupNewEmployees(@RequestBody EmpTitleSalary empTitleSalary){
        empManagerService.setupNewEmployees(empTitleSalary);
    }
    @PutMapping("/changeEmpDept/{empNo}/{deptNo}")
    public void changeDept(@PathVariable int empNo,@PathVariable String deptNo){
        empManagerService.changeDept(empNo, deptNo);
    }
}
