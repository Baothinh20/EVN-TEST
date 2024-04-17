package JAVA_9.utils.salary;

import org.springframework.stereotype.Component;

@Component("year")
public class YearSalary implements CalculateSalary {
    @Override
    public long calculateSalary(long salary) {
        return salary * 12;
    }
}
