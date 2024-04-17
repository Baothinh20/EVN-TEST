package JAVA_9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"employees"})
public class Salaries {

    @ManyToOne
    @JoinColumn(name = "emp_no")
    private Employees employees;

    @Column(name = "salary")
    private int salary;

    @Id
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "from_date")
    private LocalDate fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_date")
    private LocalDate toDate;

}
