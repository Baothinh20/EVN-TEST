package JAVA_9.service;

import JAVA_9.entity.Salaries;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface SalariesService {
    public List<Salaries> getAllSalaries();
    public Salaries createSalary(Salaries salary);
    public Salaries updateSalary(Salaries salary);
    public void deleteSalary();
    public List<Salaries> getSalariesById(LocalDate fromDate);

    public Long getTotalSalary(int month, int year);
}
