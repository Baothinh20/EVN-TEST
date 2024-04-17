package JAVA_9.dto;

import JAVA_9.entity.Gender;
import lombok.Data;

import java.time.LocalDate;
@Data
public class EmployeesDTOImpl {
    private Integer empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate hireDate;
    private Integer salary;
    private String title;
}
