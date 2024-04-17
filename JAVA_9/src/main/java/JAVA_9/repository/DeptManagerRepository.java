package JAVA_9.repository;

import JAVA_9.entity.DeptManager;
import JAVA_9.entity.Key.DeptManagerKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager, DeptManagerKey> {
}
