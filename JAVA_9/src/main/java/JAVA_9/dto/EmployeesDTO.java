package JAVA_9.dto;

import java.time.LocalDate;

public interface EmployeesDTO {
    Integer getEmpNo();
    LocalDate getBirthDate();
    String getFirstName();
    String getLastName();
    String getGender();
    LocalDate getHireDate();
    String getTitle();
    Integer getSalary();
}