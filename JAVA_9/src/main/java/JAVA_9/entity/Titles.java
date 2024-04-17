package JAVA_9.entity;

import JAVA_9.entity.Key.TitlesKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Entity
@Table(name = "titles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"employees"})
public class Titles {

    @ManyToOne
    @JoinColumn(name = "emp_no")
    @JsonIgnore
    private Employees employees;

    @EmbeddedId
    private TitlesKey titlesKey;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "to_date")
    private LocalDate toDate;
}
