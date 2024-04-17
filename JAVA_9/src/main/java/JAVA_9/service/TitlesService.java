package JAVA_9.service;

import JAVA_9.entity.Titles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TitlesService {
    public List<Titles> getAllTitles();
    public Titles createTitle(Titles title);
    public Titles updateTitle(Titles title);
    public void deleteTitle();
}
