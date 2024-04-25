package JAVA_9.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employees {

    @Id
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "hire_date")
    private LocalDate hireDate;

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch= FetchType.LAZY, mappedBy = "employees")
    // @JsonManagedReference
    @JsonIgnore
    private Set<Salaries> salaries = new HashSet<>();

    @OneToMany(cascade = {CascadeType.REMOVE}, fetch= FetchType.LAZY, mappedBy = "employees")
    @JsonIgnore
    private Set<Titles> titles = new HashSet<>();
}
