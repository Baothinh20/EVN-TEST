package JAVA_9.controller;

import JAVA_9.entity.Salaries;
import JAVA_9.service.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SalariesController {
    @Autowired
    private SalariesService salariesService;
    @GetMapping("/getAllSalaries")
    public List<Salaries> getAllSalaries(){
        return salariesService.getAllSalaries();
    }
    @GetMapping("/getSalariesById/{fromDate}")
    public List<Salaries> getSalariesById(@PathVariable LocalDate fromDate){
        return salariesService.getSalariesById(fromDate);
    }
}
