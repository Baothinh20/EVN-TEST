package JAVA_9.repository;

import JAVA_9.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {
    public Department findByDeptNo(String deptNo);
}
