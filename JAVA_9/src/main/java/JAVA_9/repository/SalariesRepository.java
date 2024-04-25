package JAVA_9.repository;

import JAVA_9.entity.Employees;
import JAVA_9.entity.Key.SalaryKey;
import JAVA_9.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, SalaryKey> {
    List<Salaries> findByFromDate(LocalDate localDate);

    @Query(value = "WITH e_info AS(\n" +
            "SELECT e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date, s.salary, s.from_date, s.to_date, de.dept_no FROM employees e\n" +
            "LEFT JOIN dept_emp de ON de.emp_no = e.emp_no\n" +
            "LEFT JOIN salaries s ON s.emp_no = e.emp_no\n" +
            "WHERE s.from_date < \"1991-05-01\" AND s.to_date >= \"1991-05-01\"\n" +
            "AND de.from_date < \"1991-05-01\" AND de.to_date >= \"1991-05-01\")\n" +
            "SELECT dept_no, sum(salary) FROM e_info Group BY dept_no;",nativeQuery = true)
    List<Salaries> findByDatePerDept(String month, String year);

    @Query(value = "SELECT e.emp_no, e.birth_date, e.first_name, e.last_name, e.gender, e.hire_date, s.salary, s.from_date, s.to_date FROM employees e\n" +
            "LEFT JOIN salaries s ON s.emp_no = e.emp_no\n" +
            "WHERE s.from_date < \"1991-05-01\" AND s.to_date >= \"1991-05-01\" ",nativeQuery = true)
    List<Salaries> findByDatePerEmp(String month, String year);

    @Query(value = "SELECT * FROM salaries WHERE ((YEAR(from_date) = :year AND MONTH(from_date) <= :month) OR (YEAR(to_date) = :year AND MONTH(to_date) > :month)) ",nativeQuery = true)
    List<Salaries> findByDateAll(int month, int year);
}
