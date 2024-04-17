package JAVA_9.entity.Key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitlesKey implements Serializable {
    @Column(name = "title")
    private String title;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "from_date")
    private LocalDate fromDate;

}
