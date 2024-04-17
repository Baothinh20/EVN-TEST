package JAVA_9.service.impl;

import JAVA_9.entity.Titles;
import JAVA_9.repository.TitlesRepository;
import JAVA_9.service.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitlesServiceImpl implements TitlesService {

    @Autowired
    private TitlesRepository titlesRepository;

    @Override
    public List<Titles> getAllTitles() {
        return titlesRepository.findAll();
    }

    @Override
    public Titles createTitle(Titles title) {
        return titlesRepository.save(title);
    }

    @Override
    public Titles updateTitle(Titles title) {
        return titlesRepository.save(title);
    }
    @Override
    public void deleteTitle() {

    }
}
