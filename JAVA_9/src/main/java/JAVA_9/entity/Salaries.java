package JAVA_9.entity;

import JAVA_9.entity.Key.SalaryKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "salaries")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"employees"})
public class Salaries {

    @EmbeddedId
    private SalaryKey salaryKey;

    @Column(name = "salary")
    private int salary;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_date")
    private LocalDate toDate;

}
