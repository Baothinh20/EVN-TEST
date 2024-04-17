package JAVA_9.utils.salary;

import org.springframework.stereotype.Component;

@Component("month")
public class MonthSalary implements CalculateSalary {
    @Override
    public long calculateSalary(long salary) {
        return salary;
    }
}
