package JAVA_9.controller;



import JAVA_9.dto.EmployeesDTO;
import JAVA_9.entity.Employees;
import JAVA_9.service.EmployeesService;
import JAVA_9.specification.EmployeeSpecificationBuilder;
import JAVA_9.utils.filter.SearchOperation;
import com.google.common.base.Joiner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeesService employeesService;

    //CRUD
    @GetMapping("/getAllEmployees")
    public List<Employees> getAllEmployees(){
        return employeesService.getAllEmployees();
    }
    @PostMapping("/createEmployee")
    public  Employees createEmployee(@RequestBody Employees employees) {
        return employeesService.createEmployee(employees);
    }
    @PutMapping("/updateEmployee")
    public  Employees updateEmployee(@RequestBody Employees employees){
        return employeesService.createEmployee(employees);
    }
    @DeleteMapping("/deleteEmployee")
    public void deleteEmployee(){
        employeesService.deleteEmployee();
    }

    @GetMapping("/getEmployeesById/{empNo}")
    public Employees findByEmpNo(@PathVariable int empNo){
        return employeesService.findByEmpNo(empNo);
    }
    @GetMapping("/getEmployeesDTOById/{empNo}")
    public List<EmployeesDTO> findByEmpNo(@PathVariable Integer empNo){
        return employeesService.findByEmpNoDTO(empNo);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    @ResponseBody
    public List<Employees> findAllBySpecification(@RequestParam(value = "search") String search){
        EmployeeSpecificationBuilder builder = new EmployeeSpecificationBuilder();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)((\\d{2,4}\\-\\d{1,2}\\-\\d{1,2})|(\\w+?))(\\p{Punct}?),");
        // Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while(matcher.find()){
            builder.with(matcher.group(1), matcher.group(2), matcher.group(4), matcher.group(3), matcher.group(5));
        }

        Specification<Employees> spec = builder.build();
        return employeesService.findAll(spec);
    }
}
