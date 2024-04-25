package JAVA_9.service.impl;

import JAVA_9.entity.Salaries;
import JAVA_9.repository.SalariesRepository;
import JAVA_9.service.SalariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SalariesServiceImpl implements SalariesService {

    @Autowired
    private SalariesRepository salariesRepository;

    @Override
    public List<Salaries> getAllSalaries() {
        return salariesRepository.findAll();
    }

    @Override
    public Salaries createSalary(Salaries salary) {
        return salariesRepository.save(salary);
    }

    @Override
    public Salaries updateSalary(Salaries salary) {
        return salariesRepository.save(salary);
    }

    @Override
    public void deleteSalary() {

    }

    @Override
    public List<Salaries> getSalariesById(LocalDate fromDate) {
        return salariesRepository.findByFromDate(fromDate);
    }

    @Override
    public List<Salaries> getByDateAll(int month, int year) {
        return salariesRepository.findByDateAll(month, year);
    }

}
