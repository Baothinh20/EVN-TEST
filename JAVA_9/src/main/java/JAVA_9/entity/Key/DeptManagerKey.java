package JAVA_9.entity.Key;

import JAVA_9.entity.Department;
import JAVA_9.entity.Employees;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptManagerKey implements Serializable {

    @ManyToOne
    @JoinColumn(name = "dept_no")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "emp_no")
    private Employees employees;
}
