package JAVA_9.repository;

import JAVA_9.entity.Employees;
import JAVA_9.entity.Salaries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SalariesRepository extends JpaRepository<Salaries, LocalDate> {
    List<Salaries> findByFromDate(LocalDate fromDate);
    @Query(value = "",nativeQuery = true)
    List<Salaries> findByDateBetweenFromDateAndToDate(int month, int year);
}
