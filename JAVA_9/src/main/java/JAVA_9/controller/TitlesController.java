package JAVA_9.controller;

import JAVA_9.service.TitlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TitlesController {
    @Autowired
    private TitlesService titlesService;
}
