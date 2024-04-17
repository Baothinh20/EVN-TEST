package JAVA_9.repository;

import JAVA_9.entity.DeptEmp;
import JAVA_9.entity.Key.DeptEmpKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, DeptEmpKey> {
    @Procedure(value = "Change_Emp_Dept")
    public void changeEmpDept(int empNo, String deptNo);
}
