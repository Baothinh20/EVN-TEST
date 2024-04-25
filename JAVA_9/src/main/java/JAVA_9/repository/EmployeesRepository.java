package JAVA_9.repository;

import JAVA_9.dto.EmployeesDTO;
import JAVA_9.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees,Integer>, JpaSpecificationExecutor<Employees> {
    public Employees findByEmpNo(int empNo);

    @Query(value = "SELECT e.emp_no AS empNo, e.birth_date AS birthDate, e.first_name AS firstName, e.last_name AS lastName, e.gender AS gender, e.hire_date AS hireDate, s.salary AS salary, t.title AS title FROM employees e\n" +
            "INNER JOIN salaries s ON s.emp_no = e.emp_no\n" +
            "INNER JOIN titles t ON t.emp_no = e.emp_no\n" +
            "WHERE e.emp_no = ?1", nativeQuery = true)
    public List<EmployeesDTO> findByEmpNoDTO(Integer empNo);
}
