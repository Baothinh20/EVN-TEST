package JAVA_9.repository;

import JAVA_9.entity.Titles;
import JAVA_9.entity.Key.TitlesKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitlesRepository extends JpaRepository<Titles, TitlesKey> {
}
