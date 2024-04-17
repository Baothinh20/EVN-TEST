package JAVA_9.dto;

import JAVA_9.entity.Employees;
import JAVA_9.entity.Salaries;
import JAVA_9.entity.Titles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpTitleSalary {
    private Employees employees;
    private Titles titles;
    private Salaries salaries;

}
